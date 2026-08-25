import java.util.Scanner;

abstract class Loan {
    protected double principal;
    protected double rate;
    protected double time;

    public Loan(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {

    public HomeLoan(double principal, double time) {
        super(principal, 8.0, time);
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100.0;
    }

    @Override
    public String toString() {
        return "Home Loan Interest: " + calculateInterest();
    }
}

class CarLoan extends Loan {

    public CarLoan(double principal, double time) {
        super(principal, 10.0, time);
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100.0;
    }

    @Override
    public String toString() {
        return "Car Loan Interest: " + calculateInterest();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            
            String[] details = line.split(",");
            
            if (details.length == 3) {
                String loanType = details[0].trim();
                double principal = Double.parseDouble(details[1].trim());
                double time = Double.parseDouble(details[2].trim());
                
                Loan loan = null;
                
                if (loanType.equalsIgnoreCase("Home")) {
                    loan = new HomeLoan(principal, time);
                } else if (loanType.equalsIgnoreCase("Car")) {
                    loan = new CarLoan(principal, time);
                }
                
                if (loan != null) {
                    System.out.println(loan.toString());
                } else {
                    System.out.println("Invalid loan type entered.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
        
        scanner.close();
    }
}