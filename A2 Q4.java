import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productName;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = " + (price * quantity);
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product p) {
        this.products.add(p);
    }

    public int calculateTotal() {
        int total = 0;
        for (Product p : products) {
            total += (p.getPrice() * p.getQuantity());
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Products:\n");
        
        for (Product p : products) {
            sb.append(p.toString()).append("\n");
        }
        
        sb.append("Total: ").append(calculateTotal());
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String[] firstLine = scanner.nextLine().trim().split(" ");
            
            if (firstLine.length == 2) {
                String orderId = firstLine[0];
                int numProducts = Integer.parseInt(firstLine[1]);
                
                Order order = new Order(orderId);
                
                for (int i = 0; i < numProducts; i++) {
                    String[] prodInput = scanner.nextLine().trim().split(",");
                    String name = prodInput[0].trim();
                    int price = Integer.parseInt(prodInput[1].trim());
                    int quantity = Integer.parseInt(prodInput[2].trim());
                    
                    Product product = new Product(name, price, quantity);
                    order.addProduct(product);
                }
                
                System.out.println(order.toString());
            }
        }
        
        scanner.close();
    }
}