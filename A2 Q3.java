import java.util.Scanner;

class Employee {
    private String name;
    private String id;
    private double basicSalary;

    public Employee() {
    }

    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return "Employee " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " (" + getId() + ") Salary: " + calculateSalary();
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
            String type = details[0].trim();
            
            if (type.equalsIgnoreCase("Employee") && details.length == 4) {
                String name = details[1].trim();
                String id = details[2].trim();
                double basicSalary = Double.parseDouble(details[3].trim());
                
                Employee emp = new Employee(name, id, basicSalary);
                System.out.println(emp.toString());
                
            } else if (type.equalsIgnoreCase("Manager") && details.length == 5) {
                String name = details[1].trim();
                String id = details[2].trim();
                double basicSalary = Double.parseDouble(details[3].trim());
                double bonus = Double.parseDouble(details[4].trim());
                
                Manager mgr = new Manager(name, id, basicSalary, bonus);
                System.out.println(mgr.toString());
            } else {
                System.out.println("Invalid input format.");
            }
        }
        
        scanner.close();
    }
}