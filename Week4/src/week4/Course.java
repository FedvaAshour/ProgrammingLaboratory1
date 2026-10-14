
package week4;

import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    int capacity;
    List<Student> enrolledStudents;


    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>(); 
    }


    public void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + enrolledStudents.size() + " / " + capacity);
        System.out.println("Enrolled Students:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("  (No students enrolled yet)");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("  - ID: " + student.studentID + ", Name: " + student.name);
            }
        }
        System.out.println("----------------------------------");
    }
}
