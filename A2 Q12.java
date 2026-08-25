import java.util.Scanner;

class Vehicle {
    private String regNo;
    private String brand;
    protected double baseRate;

    public Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public double calculateRent() {
        return baseRate;
    }

    @Override
    public String toString() {
        return regNo + " " + brand + " Rent: " + calculateRent();
    }
}

class Car extends Vehicle {

    public Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.5;
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }
}

class Bike extends Vehicle {

    public Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.2;
    }

    @Override
    public String toString() {
        return "Bike " + super.toString();
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
            
            if (details.length == 4) {
                String vehicleType = details[0].trim();
                String regNo = details[1].trim();
                String brand = details[2].trim();
                double baseRate = Double.parseDouble(details[3].trim());
                
                Vehicle vehicle = null;
                
                if (vehicleType.equalsIgnoreCase("Car")) {
                    vehicle = new Car(regNo, brand, baseRate);
                } else if (vehicleType.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike(regNo, brand, baseRate);
                }
                
                if (vehicle != null) {
                    System.out.println(vehicle.toString());
                } else {
                    System.out.println("Invalid vehicle type entered.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
        
        scanner.close();
    }
}