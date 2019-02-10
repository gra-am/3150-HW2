package org.openjfx;

public class Course {

  enum CourseType {
    English, Math, History;
  }

  public CourseType type;
  public int crn;
  public String name;

  Course(){}

  Course(String type, int crn, String name){
    this.type = CourseType.valueOf(type);
    this.crn = crn;
    this.name = name;
  }

  public String getCourseString(){
    return type.toString() + ", " + crn + ", " + name;
  }

  public int getCrn(){
    return crn;
  }
}
