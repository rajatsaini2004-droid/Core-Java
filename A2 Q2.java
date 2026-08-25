import java.util.Scanner;

abstract class Flight {
    private String flightNumber;
    private String airline;
    private double fare;

    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public abstract double calculateFare();

    @Override
    public String toString() {
        return "Flight No: " + flightNumber + " Airline: " + airline + " Fare: " + calculateFare();
    }
}

class DomesticFlight extends Flight {
    public DomesticFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        // Base fare + 10% tax
        return getFare() + (getFare() * 0.10);
    }
}

class InternationalFlight extends Flight {
    public InternationalFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        // Base fare + 25% tax
        return getFare() + (getFare() * 0.25);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter flight type,number,airline,fare");
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            
            String[] flightDetails = line.split(",");
            
            if (flightDetails.length == 4) {
                String type = flightDetails[0].trim();
                String flightNumber = flightDetails[1].trim();
                String airline = flightDetails[2].trim();
                double baseFare = Double.parseDouble(flightDetails[3].trim());
                
                Flight flight = null;
                
                if (type.equalsIgnoreCase("Domestic")) {
                    flight = new DomesticFlight(flightNumber, airline, baseFare);
                } else if (type.equalsIgnoreCase("International")) {
                    flight = new InternationalFlight(flightNumber, airline, baseFare);
                }
                
                if (flight != null) {
                    System.out.println(flight.toString());
                } else {
                    System.out.println("Invalid flight type entered.");
                }
            }
        }
        
        scanner.close();
    }
}