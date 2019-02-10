package org.openjfx;

import java.io.*;
import java.util.*;

public class RunCourses{
  //goals: assemble courselist from io file
  //       use BufferedReader
  //       manipulate using text line UI
  //       write courselist to io file
  //       save, exit

  public static void main(String args[]) {
    String line = null;
    String[] lines;

    Course tempCourse = new Course();
    CourseList courses = new CourseList(6, "My Courses");

    Scanner s = new Scanner(System.in);
		boolean escape = false;

    try {
      FileReader fr = new FileReader("CourseData.txt");

      BufferedReader br = new BufferedReader(fr);
      while ((line = br.readLine()) != null) {
            lines = line.split(", ", -1);

            switch(lines[0]){
              case "History": tempCourse = new HistoryCourse(lines[0], Integer.valueOf(lines[1]), lines[2], lines[3], lines[4]);
                break;
              case "Math": tempCourse = new MathCourse(lines[0], Integer.valueOf(lines[1]), lines[2], lines[3], lines[4]);
                break;
              case "English": tempCourse = new EnglishCourse(lines[0], Integer.valueOf(lines[1]), lines[2], lines[3], lines[4]);
                break;
            }
            courses.addCourse(tempCourse);
         }

      br.close();

    } catch (IOException e) {
        System.out.println("Problem reading file, exiting");
        e.printStackTrace();
        System.exit(0);
    }

    while(!escape)
		{

			System.out.println("Main Menu:");
			System.out.println("	1. View Courses");
			System.out.println("	2. Find Courses");
			System.out.println("	3. Delete Course");
      System.out.println("	4. Exit");

			int selection = Integer.parseInt(s.nextLine());
      switch(selection){
        case 1:
          boolean viewEscape = false;
          loop: while(!viewEscape){
            for(Course meme: courses.courseArray()){
              System.out.println(meme.getCourseString());
            }
            viewEscape = true;
          }
          break;

        case 2:
          System.out.println("Enter search crn:");
          String searchCRN = s.nextLine();
          for(Course meme: courses.courseArray()){
            if(Integer.valueOf(searchCRN).equals(meme.getCrn())){
              System.out.println(meme.getCourseString());
            }
          }
          break;

        case 3:
          System.out.println("Enter crn to delete:");
          String deleteCRN = s.nextLine();
          for(int i = 0; i < courses.length(); i++){
            if(Integer.valueOf(deleteCRN).equals(courses.courseAt(i).getCrn())){
              courses.removeFrom(i);
              System.out.println(courses.courseAt(i).getCourseString() + " deleted.");
            }
          }
          break;

        case 4:
          System.out.println("Exit Software? Type \"yes\"");
					String exitQuery = s.nextLine();
					if (exitQuery.equals("yes"))
						escape = true;
          break;
        default:
          System.out.println("Invalid Command");
          break;
      }
    }

    try {
      FileWriter fw = new FileWriter("CourseData.txt");
      BufferedWriter bw = new BufferedWriter(fw);

      for(Course meme : courses.courseArray()){
        bw.write(meme.getCourseString());
        bw.newLine();
      }

      bw.close();

    } catch (IOException e){
        System.out.println("Problem reading file, exiting");
        e.printStackTrace();
        System.exit(0);
    }
  }
}
