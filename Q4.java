import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Are you a citizen? (true or false): ");
        boolean isCitizen = scanner.nextBoolean();
        
        System.out.println("\n--- Eligibility Result ---");
        
        if (age >= 18 && isCitizen) {
            System.out.println("Result: You are eligible to vote!");
        } else {
            System.out.println("Result: You are NOT eligible to vote.");
            
            if (!isCitizen) {
                System.out.println("- Reason: You must be a citizen.");
            }
            
            if (age < 18 || !isCitizen) {
                System.out.println("- Note: You missed one or more mandatory requirements.");
            }
        }
        
        scanner.close();
    }
}
