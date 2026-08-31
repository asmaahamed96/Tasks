public class Task6 {
        public static void main(String[] args) {

            String text = null;
            int number = 10;
            int divisor = 0;

            try {

                System.out.println(text.toUpperCase());

                int result = number / divisor;

                System.out.println(result);

            } catch (NullPointerException e) {

                System.out.println("String is null!");

            } catch (ArithmeticException e) {

                System.out.println("Cannot divide by zero!");

            }
        }
    }
