import java.util.Scanner;

class Passport {
    private String passportNo;
    private String issueDate;
    private String expiryDate;

    public Passport() {
    }

    public Passport(String passportNo, String issueDate, String expiryDate) {
        this.passportNo = passportNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Passport: " + passportNo + " Issue: " + issueDate + " Expiry: " + expiryDate;
    }
}

class Citizen {
    private String name;
    private String dob;
    private String address;
    private Passport passport;

    public Citizen() {
    }

    public Citizen(String name, String dob, String address, Passport passport) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Citizen: " + name + "\nDOB: " + dob + "\nAddress: " + address + "\n" + passport.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String citizenLine = scanner.nextLine().trim();
            
            if (scanner.hasNextLine()) {
                String passportLine = scanner.nextLine().trim();
                
                if (!citizenLine.isEmpty() && !passportLine.isEmpty()) {
                    String[] citizenDetails = citizenLine.split(",");
                    String[] passportDetails = passportLine.split(",");
                    
                    if (citizenDetails.length == 3 && passportDetails.length == 3) {
                        String name = citizenDetails[0].trim();
                        String dob = citizenDetails[1].trim();
                        String address = citizenDetails[2].trim();
                        
                        String passportNo = passportDetails[0].trim();
                        String issueDate = passportDetails[1].trim();
                        String expiryDate = passportDetails[2].trim();
                        
                        Passport passport = new Passport(passportNo, issueDate, expiryDate);
                        Citizen citizen = new Citizen(name, dob, address, passport);
                        
                        System.out.println(citizen.toString());
                    } else {
                        System.out.println("Invalid input format.");
                    }
                }
            }
        }
        
        scanner.close();
    }
}