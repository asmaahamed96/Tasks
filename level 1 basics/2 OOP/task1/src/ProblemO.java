import java.util.Scanner;

public class ProblemO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char operator = input.charAt(i);
            if (operator == '+') {
                String firstNumber = input.substring(0, i);
                String secondNumber = input.substring(i + 1);
                result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            } else if (operator == '-') {
                String firstNumber = input.substring(0, i);
                String secondNumber = input.substring(i + 1);
                result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
            } else if (operator == '*') {
                String firstNumber = input.substring(0, i);
                String secondNumber = input.substring(i + 1);
                result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
            } else if (operator == '/') {
                String firstNumber = input.substring(0, i);
                String secondNumber = input.substring(i + 1);
                result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            }
        }
        System.out.println(result);
    }
}