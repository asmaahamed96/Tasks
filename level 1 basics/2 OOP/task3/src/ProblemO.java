
import java.util.Scanner;

public class ProblemO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i<=n; i++){
            System.out.println("*".repeat(i));
        }
    }
}
