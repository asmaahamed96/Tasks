import java.util.Scanner;

public class ProblemZ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();
        //a^b > c^d
        double left = b * Math.log(a);
        double right = d * Math.log(c);

        System.out.println(left > right ? "YES" : "NO");

    }
}