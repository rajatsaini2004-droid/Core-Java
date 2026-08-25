import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author: " + name + " (" + gender + "), Email: " + email;
    }
}

class Book {
    private String title;
    private int price;
    private Author author;

    public Book(String title, int price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + title + "\nPrice: " + price + "\n" + author.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            
            if (!inputLine.isEmpty()) {
                String[] details = inputLine.split(",");
                
                if (details.length == 5) {
                    String title = details[0].trim();
                    int price = Integer.parseInt(details[1].trim());
                    String authorName = details[2].trim();
                    String email = details[3].trim();
                    char gender = details[4].trim().charAt(0);
                    
                    Author author = new Author(authorName, email, gender);
                    
                    Book book = new Book(title, price, author);
                    
                    System.out.println(book.toString());
                } else {
                    System.out.println("Invalid input format.");
                }
            }
        }
        
        scanner.close();
    }
}