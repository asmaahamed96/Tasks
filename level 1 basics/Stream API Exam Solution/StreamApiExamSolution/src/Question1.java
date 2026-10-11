
public class Question1 {
    public static void main(String[] args) {
        String input = "swiss";
        char result = input.chars()
                        .mapToObj(c -> (char)c)
                .filter(c -> input.indexOf(c)== input.lastIndexOf(c))
                .findFirst()
                .orElse(null);
        System.out.println(result);

    }
}
