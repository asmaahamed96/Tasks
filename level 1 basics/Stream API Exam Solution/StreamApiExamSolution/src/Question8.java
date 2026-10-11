import java.util.*;

public class Question8 {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 4);

        List<Integer> result = list1.stream()
                .filter(list2::contains)
                .distinct()
                .toList();

        System.out.println(result);
    }
}