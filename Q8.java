import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        
        // Declare an integer array to hold 5 marks
        int[] marks = new int[5];

        System.out.println("Please enter the marks for 5 students:");

        // 1. Read marks into the array
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        System.out.println("\n--- Marks Record ---");

        // 2. Print each student's marks
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + " scored: " + marks[i]);
        }

        // Close the scanner to prevent resource leaks
        scanner.close(); 
    }
}