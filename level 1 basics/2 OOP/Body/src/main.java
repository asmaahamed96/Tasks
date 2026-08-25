import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("start program..");
        try {
            getNumber(1);
        }
     catch (Exception exception){
         System.out.println("error "+ exception.getMessage());
     }
        System.out.println("end program..");

      /* System.out.println(1/0);

        try {
            System.out.println("start app..............");
            Scanner scanner=new Scanner(System.in);
            System.out.println("pls enter your id");

            int id=0;
            id=scanner.nextInt();//input mismatchException
            System.out.println("success your id: " +id);

        }catch (Exception exception){
            System.out.println("error " + exception.getMessage());
        }*/
    }

    public static void getNumber(int num){
if (num==1)
{ RuntimeException exception=new RuntimeException("invalid number");
    throw exception;

}
        System.out.println("your number : "+num);
    }
}
