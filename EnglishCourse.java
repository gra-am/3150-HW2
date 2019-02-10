package org.openjfx;

public class EnglishCourse extends Course {

  enum CourseLevel {
    Freshman, Sophomore, Junior, Senior;
  }

  enum CourseSpecialization {
    Reading, Writing, Comprehensive;
  }

  CourseLevel level;
  CourseSpecialization spec;

  EnglishCourse(String type, int crn, String name, String newLevel, String newSpec){
    super(type, crn, name);
    this.level = CourseLevel.valueOf(newLevel);
    this.spec = CourseSpecialization.valueOf(newSpec);
  }

  public String getCourseString(){
    return super.getCourseString() + ", " + level.toString() + ", " + spec.toString();
  }
}
