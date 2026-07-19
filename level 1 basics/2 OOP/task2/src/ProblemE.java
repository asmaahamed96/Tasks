import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOdds = scanner.nextInt();
        int numberOfEvens = scanner.nextInt();

        if(numberOfOdds == 0 && numberOfEvens == 0) {
            System.out.println("NO");
        } else if (numberOfEvens == numberOfOdds || numberOfEvens == numberOfOdds + 1) {
            System.out.println("YES");
        } else if (numberOfOdds == numberOfEvens + 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
