import java.util.Scanner;

public class ProblemI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int firstDigit = n / 10;
        int secondDigit = n % 10;
        if (firstDigit == 0 || secondDigit == 0) {
            System.out.println("YES");
        } else {
            if (firstDigit % secondDigit == 0 || secondDigit % firstDigit == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}