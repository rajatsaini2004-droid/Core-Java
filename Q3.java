import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        
        System.out.println("\n--- Arithmetic Results ---");
        
        int sum = num1 + num2;
        System.out.println("Addition (" + num1 + " + " + num2 + ") = " + sum);
        
        int difference = num1 - num2;
        System.out.println("Subtraction (" + num1 + " - " + num2 + ") = " + difference);
        
        int product = num1 * num2;
        System.out.println("Multiplication (" + num1 + " * " + num2 + ") = " + product);
        
        if (num2 != 0) {
            int quotient = num1 / num2;
            int remainder = num1 % num2;
            
            System.out.println("Division (" + num1 + " / " + num2 + ") = " + quotient);
            System.out.println("Modulus (" + num1 + " % " + num2 + ") = " + remainder);
        } else {
            System.out.println("Division: Cannot divide by zero.");
            System.out.println("Modulus: Cannot calculate modulus with zero.");
        }
        
        scanner.close();
    }
}