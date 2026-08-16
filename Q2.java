public class TemperatureConverter {
    public static void main(String[] args) {
        
        int celsius = 42; 
        
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        
        System.out.println("--- Temperature Conversion ---");
        System.out.println("Celsius: " + celsius + "°C");
        System.out.println("Fahrenheit: " + fahrenheit + "°F");
    }
}
