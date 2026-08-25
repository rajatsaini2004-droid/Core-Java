import java.util.Scanner;

interface Device {
    void turnOn();
    void turnOff();
}

class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Fan is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is now OFF");
    }
}

class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Light is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is now OFF");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                break;
            }
            
            Device device = null;
            
            if (input.equalsIgnoreCase("Fan")) {
                device = new Fan();
            } else if (input.equalsIgnoreCase("Light")) {
                device = new Light();
            } else {
                System.out.println("Unknown device entered.");
                continue;
            }
            
            device.turnOn();
            device.turnOff();
        }
        
        scanner.close();
    }
}