package org.openjfx;

public class HistoryCourse extends Course {

  enum AreaE{
    Eligible, NotEligible;
  }

  enum CourseLocation{
    Recorded, Online, InPerson;
  }

  AreaE e;
  CourseLocation loc;

  HistoryCourse(String type, int crn, String name, String newE, String newLoc){
    super(type, crn, name);
    this.e = AreaE.valueOf(newE);
    this.loc = CourseLocation.valueOf(newLoc);
  }

  public String getCourseString(){
    return super.getCourseString() + ", " + e.toString() + ", " + loc.toString();
  }
}
