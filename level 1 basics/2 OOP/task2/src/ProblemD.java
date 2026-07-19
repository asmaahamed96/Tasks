import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        if (a + b * c == d || a * b + c == d || a - b * c == d || a * b - c == d || a + b - c == d || a - b + c == d) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
