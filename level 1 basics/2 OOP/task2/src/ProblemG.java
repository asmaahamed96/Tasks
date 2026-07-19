import java.util.Scanner;

public class ProblemG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();

        long first = Math.min(n, m);
        first = Math.min(first, k);

        n -= first;
        k -= first;

        long second = Math.min(n / 2, k);

        System.out.println(first + second);

    }
}