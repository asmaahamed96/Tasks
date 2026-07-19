import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long k = scanner.nextLong();
        if (a%k==0 && b%k==0){
            System.out.println("Both");
        } else if (a%k==0){
            System.out.println("Memo");
        } else if (b%k==0){
            System.out.println("Momo");
        } else {
            System.out.println("No One");
        }
    }
}
