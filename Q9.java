import java.util.Scanner;

public class FindMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Please enter 10 integers:");

        // 1. Read 10 integers into the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // 2. Assume the first number is the maximum to start
        int max = numbers[0];

        // 3. Loop through the remaining elements to find the true maximum
        for (int i = 1; i < numbers.length; i++) {
            // If the current number is greater than our recorded max, update max
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Print the result
        System.out.println("\nThe maximum value in the array is: " + max);

        // Close the scanner
        scanner.close();
    }
}