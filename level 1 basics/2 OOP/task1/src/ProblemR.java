
import java.util.Scanner;

public class ProblemR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ageInDays = scanner.nextInt();
        int years = ageInDays / 365;
        int months = (ageInDays % 365) / 30;
        int days = (ageInDays % 365) % 30;
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(days + " days");
    }
}