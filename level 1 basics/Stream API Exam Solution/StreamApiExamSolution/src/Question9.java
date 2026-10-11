import java.util.*;
import java.util.stream.Collectors;

public class Question9 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                1, 2, 2, 3, 3, 3,
                4, 4, 4, 4, 5, 5, 5, 6
        );

        Map<Integer, Long> frequency = numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ));

        frequency.entrySet().stream()
                .sorted(
                        Map.Entry.<Integer, Long>comparingByValue()
                                .reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(3)
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " = " +
                                        entry.getValue() + " occurrences"
                        )
                );
    }
}