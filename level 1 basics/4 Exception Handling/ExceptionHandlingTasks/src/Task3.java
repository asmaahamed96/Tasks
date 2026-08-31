public class Task3 {

        public static String convertToUpperCase(String text) {
            return text.toUpperCase();
        }

        public static void main(String[] args) {

            String text = null;

            try {

                String result = convertToUpperCase(text);

                System.out.println(result);

            } catch (NullPointerException e) {

                System.out.println("The string cannot be null!");

            }
        }
    }
