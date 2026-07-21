import java.util.Scanner;

public class ProblemH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number < 2) {
            System.out.println("NO");
            return;
        }

        boolean isPrime = true;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "YES" : "NO");
    }
}