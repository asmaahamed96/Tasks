import java.util.Scanner;

public class Task7 {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            try {

                if (age < 18) {
                    throw new InvalidAgeException("Age must be 18 or older");
                }

                System.out.println("You are allowed!");

            } catch (InvalidAgeException e) {

                System.out.println(e.getMessage());

            }
        }
    }
