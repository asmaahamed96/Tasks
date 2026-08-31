public class Task12 {

        public static void main(String[] args) {

            try {

                System.out.println("Outer try started");

                try {

                    int result = 10 / 0;

                    System.out.println(result);

                } catch (NullPointerException e) {

                    System.out.println("Inner caught NullPointerException");

                }

                System.out.println("Outer try continues");

            } catch (ArithmeticException e) {

                System.out.println("Outer caught ArithmeticException");

            }
        }
    }
