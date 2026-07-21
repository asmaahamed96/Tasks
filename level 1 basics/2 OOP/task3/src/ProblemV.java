
import java.util.Scanner;

public class ProblemV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i =1; i<=count*4; i++){
            if (i%4==0){
                System.out.println("PUM");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
