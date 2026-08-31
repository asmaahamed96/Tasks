import java.io.FileNotFoundException;
import java.io.FileReader;
public class Task5 {

        public static void main(String[] args) {

            try {

                FileReader reader = new FileReader("test.txt");

                System.out.println("File opened successfully!");

                reader.close();

            } catch (FileNotFoundException e) {

                System.out.println("File not found!");

            } catch (Exception e) {

                System.out.println("Something went wrong!");

            }
        }
    }
