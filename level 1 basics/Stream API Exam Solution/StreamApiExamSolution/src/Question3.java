import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question3 {
    public static void main(String[] args) {
        List<Integer>numbers =
                Arrays.asList(10, 5, 20, 20, 8, 15, 10);
        Optional<Integer> secondHighNumber = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighNumber.orElse(0));

    }
}
