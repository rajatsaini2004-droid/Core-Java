public class EvenNumberSum {
    public static void main(String[] args) {
        int sum = 0;
        int num = 1; // Start checking from 1

        // Loop runs as long as num is less than or equal to 50
        while (num <= 50) {
            // Check if the number is even
            if (num % 2 == 0) {
                sum += num; // Add the even number to the total sum
            }
            num++; // Increment to check the next number
        }

        System.out.println("The sum of all even numbers between 1 and 50 is: " + sum);
    }
}