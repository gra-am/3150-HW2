package org.openjfx;

public class CourseList {
  private Course[] courses;
  private int length;
  private int capacity;
  private String name;

  //Declares an initially empty CourseList
  public CourseList(int newCapacity, String newName){
    length = 0;
    capacity = newCapacity;
    name = newName;

    courses = new Course[capacity];
  }

  //Declares a CourseList from a supplied Course[] array
  public CourseList(Course[] newCourses){
    length = newCourses.length;
    capacity = length + 1;

    courses = new Course[capacity];
  }

  //Returns true if empty
  public boolean isEmpty(){
    return length == 0;
  }

  //Returns true if full
  public boolean isFull(){
    return length == capacity;
  }

  //Returns length
  public int length(){
    return length;
  }

  //Returns the course array
  public Course[] courseArray(){
    return courses;
  }

  //Increases size of the List
  public void enlarge(){
    Course[] temp = new Course[capacity + 1];
    for(int i = 0; i < length; i++){
      temp[i] = courses[i];
    }
    courses = temp;
    capacity = courses.length;
  }

  //Adds a course to the CourseList
  //I suspect I will use this to read input from a file
  public void addCourse(Course suppliedCourse){
    if(this.isFull())
      enlarge();

    for (int i = length - 1; i >= 0; i--){
      courses[i+1] = courses[i];
    }

    courses[0] = suppliedCourse;
    length++;
  }

  public Course courseAt(int location){
    return courses[location];
  }

  //Removes a course from a location
  public void removeFrom(int location){
    Course[] tempCourses = new Course[capacity - 1];

    for(int i = 0; i < location; i ++){
      tempCourses[i] = courses[i];
    }
    for (int i = location; i < tempCourses.length; i++){
      tempCourses[i] = courses[i + 1];
    }
    courses = tempCourses;
    length--;
    capacity--;
  }

  //Gets the name of the list. redundant?
  public String getName(){
    return name;
  }

  //Sets the name to the supplied String
  public void setName(String supply){
    name = supply;
  }
}
