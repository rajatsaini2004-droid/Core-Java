import java.util.Scanner;

class Account {
    private String accNo;
    private String holderName;
    private double balance;

    public Account() {
        this.accNo = "Unknown";
        this.holderName = "Unknown";
        this.balance = 0.0;
    }

    public Account(String accNo, String holderName, double initialBalance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Account account = new Account("1010101010", "Default User", 0.0);
        
        if (scanner.hasNextInt()) {
            int numberOfOperations = scanner.nextInt();
            
            for (int i = 0; i < numberOfOperations; i++) {
                String operation = scanner.next();
                
                if (operation.equalsIgnoreCase("deposit")) {
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                } 
                else if (operation.equalsIgnoreCase("withdraw")) {
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                } 
                else if (operation.equalsIgnoreCase("getBalance")) {
                    System.out.println("Balance: " + account.getBalance());
                } 
                else {
                    System.out.println("Invalid operation.");
                }
            }
        }
        
        scanner.close();
    }
}