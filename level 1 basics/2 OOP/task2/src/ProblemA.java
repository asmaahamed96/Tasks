import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double discount = scanner.nextDouble();
        double priceAfterDiscount = scanner.nextDouble();
        double originalPrice =  (priceAfterDiscount * 100) / (100 - discount);
        System.out.printf("%.2f", originalPrice);
    }
}
