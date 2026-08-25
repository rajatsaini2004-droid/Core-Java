import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guest {
    private String name;
    private int age;
    private String idProof;

    public Guest() {
    }

    public Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
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

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + idProof;
    }
}

class Reservation {
    private String reservationId;
    private String roomType;
    private List<Guest> guests;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation ID: ").append(reservationId).append("\n");
        sb.append("Room: ").append(roomType).append("\n");
        sb.append("Guests:\n");
        
        for (int i = 0; i < guests.size(); i++) {
            sb.append(guests.get(i).toString());
            if (i < guests.size() - 1) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String[] reservationInfo = scanner.nextLine().trim().split(",");
            
            if (reservationInfo.length == 3) {
                String reservationId = reservationInfo[0].trim();
                String roomType = reservationInfo[1].trim();
                int numberOfGuests = Integer.parseInt(reservationInfo[2].trim());
                
                Reservation reservation = new Reservation(reservationId, roomType);
                
                for (int i = 0; i < numberOfGuests; i++) {
                    if (scanner.hasNextLine()) {
                        String[] guestInfo = scanner.nextLine().trim().split(",");
                        
                        if (guestInfo.length == 3) {
                            String name = guestInfo[0].trim();
                            int age = Integer.parseInt(guestInfo[1].trim());
                            String idProof = guestInfo[2].trim();
                            
                            Guest guest = new Guest(name, age, idProof);
                            reservation.addGuest(guest);
                        }
                    }
                }
                
                System.out.println(reservation.toString());
            } else {
                System.out.println("Invalid reservation input format.");
            }
        }
        
        scanner.close();
    }
}