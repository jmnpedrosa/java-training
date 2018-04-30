package class_design;

/*
 * Example of an equals() method that
 * violates the transitive rule
 */

class Course {
  
  String title;
  
  Course(String title) {
    this.title = title;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o instanceof Course) {
      Course c = (Course) o;
      return (title.equals(c.title));
    } else {
      return false;
    }
  }
}

class JavaCourse extends Course {
  
  int duration = 0;
  
  JavaCourse(String title, int duration) {
    super(title);
    this.duration = duration;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o instanceof JavaCourse) {
      return (super.equals(o) && ((JavaCourse) o).duration == duration);
    } else if (o instanceof Course) {
      return super.equals(o);
    } else {
      return false;
    }
  }
}

class BadEqualsMethod2 {
  
  public static void main(String[] args) {
    Course c1 = new JavaCourse("level1", 2);
    Course c2 = new Course("level1");
    Course c3 = new JavaCourse("level1", 12);
    
    System.out.println(c1.equals(c2));
    System.out.println(c2.equals(c3));
    System.out.println(c1.equals(c3));
  }
  
}
