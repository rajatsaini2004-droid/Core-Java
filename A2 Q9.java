import java.util.Scanner;

class Course {
    private String courseName;
    private String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return courseName + " (" + duration + ")";
    }
}

class Student {
    private String name;
    private Course enrolledCourse;

    public Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    public String getName() {
        return name;
    }

    public Course getEnrolledCourse() {
        return enrolledCourse;
    }

    @Override
    public String toString() {
        return "Student: " + name + " Course: " + enrolledCourse.toString();
    }
}

class PremiumStudent extends Student {
    private int discount;

    public PremiumStudent(String name, Course enrolledCourse, int discount) {
        super(name, enrolledCourse);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Premium Student: " + getName() + " Course: " + getEnrolledCourse().toString() + " Discount: " + discount + "%";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String courseLine = scanner.nextLine().trim();
            if (!courseLine.isEmpty()) {
                String[] courseDetails = courseLine.split(",");
                
                if (courseDetails.length == 2) {
                    String courseName = courseDetails[0].trim();
                    String duration = courseDetails[1].trim();
                    
                    Course course = new Course(courseName, duration);
                    
                    while (scanner.hasNextLine()) {
                        String studentLine = scanner.nextLine().trim();
                        if (studentLine.isEmpty()) {
                            break;
                        }
                        
                        String[] studentDetails = studentLine.split(",");
                        
                        if (studentDetails.length == 2) {
                            String name = studentDetails[0].trim();
                            Student student = new Student(name, course);
                            System.out.println(student.toString());
                            
                        } else if (studentDetails.length == 3) {
                            String name = studentDetails[0].trim();
                            int discount = Integer.parseInt(studentDetails[2].trim());
                            PremiumStudent premiumStudent = new PremiumStudent(name, course, discount);
                            System.out.println(premiumStudent.toString());
                        }
                    }
                }
            }
        }
        
        scanner.close();
    }
}