import java.util.Scanner;

public class ProblemH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long a = scanner.nextLong();

        long product = n * k;

        if (product % a != 0) {
            System.out.println("double");
        } else {
            long result = product / a;

            if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {
                System.out.println("int");
            } else {
                System.out.println("long long");
            }
        }
        }
    }

