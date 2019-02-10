package org.openjfx;

public class MathCourse extends Course {

  enum CourseSTEM {
    STEM, NonSTEM;
  }

  enum CourseLocation {
    Online, Classroom, Hybrid;
  }

  CourseSTEM stem;
  CourseLocation loc;

  MathCourse(String type, int crn, String name, String newStem, String newLoc){
    super(type, crn, name);
    this.stem = CourseSTEM.valueOf(newStem);
    this.loc = CourseLocation.valueOf(newLoc);
  }

  public String getCourseString(){
    return super.getCourseString() + ", " + stem.toString() + ", " + loc.toString();
  }
}
