import java.util.Scanner;

public class ProblemX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstStart = scanner.nextInt();
        int firstEnd = scanner.nextInt();
        int secondStart = scanner.nextInt();
        int secondEnd = scanner.nextInt();
        int start = Math.max(firstStart, secondStart);
        int end = Math.min(firstEnd, secondEnd);

        if (start <= end) {
            System.out.println(start + " " + end);
        } else {
            System.out.println(-1);
        }
    }
}