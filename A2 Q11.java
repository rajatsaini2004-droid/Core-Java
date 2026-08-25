import java.util.Scanner;

class Room {
    private String roomNumber;
    private String block;
    private String type;

    public Room() {
    }

    public Room(String roomNumber, String block, String type) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + " " + block + " " + type;
    }
}

class Student {
    private String name;
    private String roll;
    private String course;
    private Room room;

    public Student() {
    }

    public Student(String name, String roll, String course, Room room) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student: " + name + " (" + roll + ") " + course + "\n" + room.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String studentLine = scanner.nextLine().trim();
            
            if (scanner.hasNextLine()) {
                String roomLine = scanner.nextLine().trim();
                
                if (!studentLine.isEmpty() && !roomLine.isEmpty()) {
                    String[] studentDetails = studentLine.split(",");
                    String[] roomDetails = roomLine.split(",");
                    
                    if (studentDetails.length == 3 && roomDetails.length == 3) {
                        String name = studentDetails[0].trim();
                        String roll = studentDetails[1].trim();
                        String course = studentDetails[2].trim();
                        
                        String roomNumber = roomDetails[0].trim();
                        String block = roomDetails[1].trim();
                        String type = roomDetails[2].trim();
                        
                        Room room = new Room(roomNumber, block, type);
                        Student student = new Student(name, roll, course, room);
                        
                        System.out.println(student.toString());
                    } else {
                        System.out.println("Invalid input format.");
                    }
                }
            }
        }
        
        scanner.close();
    }
}