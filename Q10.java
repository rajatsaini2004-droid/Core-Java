import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to store the marks of 5 subjects
        int[] marks = new int[5];
        int sum = 0;

        System.out.println("Please enter the marks for 5 subjects (out of 100):");

        // 1. Read marks into the array and calculate the total sum
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            sum += marks[i]; // Add each mark to the total sum
        }

        // 2. Calculate the average
        // We cast 'sum' to a double to get an accurate decimal average
        double average = (double) sum / marks.length;

        // 3. Use if-else statements to determine the grade based on the average
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 75) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        // Output the final results
        System.out.println("\n--- Student Report ---");
        System.out.println("Total Marks: " + sum + " / 500");
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}