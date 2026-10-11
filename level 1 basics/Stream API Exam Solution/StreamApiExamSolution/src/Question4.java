import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Question4 {
    public static void main(String[] args) {
        String sentence = "Java Spring Java Hibernate Spring Java";
        Map<String,Long> result = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(s -> s , Collectors.counting()));
        result.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEach(System.out::println);

    }
}
