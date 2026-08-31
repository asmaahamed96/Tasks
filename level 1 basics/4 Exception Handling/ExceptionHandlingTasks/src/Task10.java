import java.io.FileReader;
import java.io.IOException;
public class Task10 {

        static void readFile() throws IOException {

            FileReader reader = new FileReader("test.txt");

            System.out.println("File opened!");

            reader.close();
        }

        public static void main(String[] args) {

            try {

                readFile();

            } catch (IOException e) {

                System.out.println("Could not read file!");

            }
        }
    }

