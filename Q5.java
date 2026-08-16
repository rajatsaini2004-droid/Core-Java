import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.println("\n--- Calculation Result ---");
        
        double result = 0;
        boolean validOperation = true; 
        
        if (operator == '+') {
            result = num1 + num2;
        } 
        else if (operator == '-') {
            result = num1 - num2;
        } 
        else if (operator == '*') {
            result = num1 * num2;
        } 
        else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Cannot divide by zero.");
                validOperation = false;
            }
        } 
        else {
            System.out.println("Error: Invalid operator entered. Please use +, -, *, or /.");
            validOperation = false;
        }
        
        if (validOperation) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
        
        scanner.close();
    }
}