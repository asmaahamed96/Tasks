import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Java", "SpringBoot", "Microservices",
                "Hibernate", "Docker");
        String longestString = words.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println(longestString);
    }
}
