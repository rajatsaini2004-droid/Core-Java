import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialization: " + specialization;
    }
}

class Surgeon extends Doctor {
    private String surgeryType;

    public Surgeon(String name, int age, String specialization, String surgeryType) {
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSurgery Type: " + surgeryType;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            
            if (!inputLine.isEmpty()) {
                String[] details = inputLine.split(",");
                
                if (details.length == 4) {
                    String name = details[0].trim();
                    int age = Integer.parseInt(details[1].trim());
                    String specialization = details[2].trim();
                    String surgeryType = details[3].trim();
                    
                    Surgeon surgeon = new Surgeon(name, age, specialization, surgeryType);
                    
                    System.out.println(surgeon.toString());
                } else {
                    System.out.println("Invalid input format.");
                }
            }
        }
        
        scanner.close();
    }
}