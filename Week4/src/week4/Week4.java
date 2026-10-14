
package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week4 {

   
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

    
        System.out.println("--- Course Setup ---");
        int numCourses = 0;
        while (true) {
            System.out.print("How many courses to create? (at least 3): ");
            try {
                numCourses = Integer.parseInt(scanner.nextLine());
                if (numCourses >= 3) {
                    break;
                } else {
                    System.out.println("Please enter at least 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();

            int capacity = 0;
            while (true) {
                System.out.print("Enter classroom capacity: ");
                try {
                    capacity = Integer.parseInt(scanner.nextLine());
                    if (capacity > 0) {
                        break;
                    } else {
                        System.out.println("Capacity must be greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            Course newCourse = new Course(courseName, capacity);
            courses.add(newCourse);
        }
       
     
        System.out.println("\nAvailable courses for registration:");
        for (Course course : courses) {
            System.out.println("- " + course.courseName);
        }

       
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1/2/3): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n--- Student Registration ---");
                System.out.print("Enter student ID: ");
                String studentID = scanner.nextLine();
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter the exact name of the course you want to register for: ");
                String targetCourseName = scanner.nextLine();

                // Kursu ismine göre arama
                Course foundCourse = null;
                for (Course course : courses) {
                    if (course.courseName.equalsIgnoreCase(targetCourseName)) {
                        foundCourse = course;
                        break;
                    }
                }

                if (foundCourse == null) {
                    System.out.println("No course found with that name: \"" + targetCourseName + "\".");
                } else if (foundCourse.enrolledStudents.size() >= foundCourse.capacity) {
                    System.out.println("This course is full. Registration failed.");
                } else {
                   
                    boolean alreadyRegistered = false;
                    for (Student student : foundCourse.enrolledStudents) {
                        if (student.studentID.equals(studentID)) {
                            alreadyRegistered = true;
                            break;
                        }
                    }

                    if (alreadyRegistered) {
                        System.out.println("This student is already registered for this course.");
                    } else {
                       
                        Student newStudent = new Student(studentID, studentName);
                        foundCourse.enrolledStudents.add(newStudent);
                        System.out.println("Registration successful.");
                    }
                }

            } else if (choice.equals("2")) {
                System.out.println("\n--- All Courses Information ---");
                for (Course course : courses) {
                    course.displayCourse();
                }

            } else if (choice.equals("3")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        
        scanner.close();
    }
}
        
        
    
    

