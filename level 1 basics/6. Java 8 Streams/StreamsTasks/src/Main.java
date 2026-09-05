import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

//        Filter even numbers from a list of integers.
        List<Integer> evens = numbers.stream().filter(n -> n%2==0).toList();
        System.out.println(evens);

//        Find names starting with a specific letter from a list of strings.
        List<String> namesStartingWithA = names.stream().filter(Objects::nonNull).filter(name -> name.startsWith("A")).toList();
        System.out.println(namesStartingWithA);

//        Convert all strings to uppercase using stream.
        List capitalizedStrings = names.stream().filter(Objects::nonNull).map(String::toUpperCase).toList();
        System.out.println(capitalizedStrings);

//        Sort a list of integers in descending order using streams.
        List<Integer> descendingOrder = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(descendingOrder);

//        Remove duplicate elements from a list using distinct().
        List<String> noDuplicates = names.stream().distinct().toList();
        System.out.println(noDuplicates);

//        Count the number of strings longer than 5 characters.
        long count = names.stream().filter(Objects::nonNull).filter(name -> name.length()>5).count();
        System.out.println(count);

//        Find the first element in a stream that matches a given condition.
        Optional<Integer> firstEven = numbers.stream().filter(n -> n%2==0).findFirst();
        System.out.println(firstEven.orElse(-1));

//        Check if any number is divisible by 5 in a list.
        boolean anyDivisibleBy5 = numbers.stream().anyMatch(n -> n%5==0);
        System.out.println(anyDivisibleBy5);

//        Collect elements into a Set instead of a List.
        Set<String> uniqueNames = names.stream().filter(Objects::nonNull).collect(Collectors.toSet());
        System.out.println(uniqueNames);

//        Skip the first 3 elements and return the rest.
        List<Integer> skippedFirstThree = numbers.stream().skip(3).toList();
        System.out.println(skippedFirstThree);

//        Calculate the sum of a list of integers using reduce.
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

//        Find the maximum and minimum value in a list.
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Max: " + max.orElse(-1));
        System.out.println("Min: " + min.orElse(-1));

//        Calculate the average of a list of doubles.
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average: " + average);

//        Multiply all integers in a list together using reduce.
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

//        Count how many numbers are positive in a list.
        long positiveCount = numbers.stream().filter(n -> n > 0).count();
        System.out.println("Positive numbers: " + positiveCount);

//        Group a list of students by their department.
       Map<String, List<Student>> studentsByDepartment = students.stream().collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("Students by department: " + studentsByDepartment);

//        Partition a list of numbers into even and odd using partitioningBy.
        Map<Boolean, List<Integer>> evenOdd = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: " + evenOdd.get(true));
        System.out.println("Odd numbers: " + evenOdd.get(false));

//        Create a comma-separated string from a list of strings.
        String commaSeparated = names.stream().filter(Objects::nonNull).collect(Collectors.joining(", "));
        System.out.println("Comma-separated: " + commaSeparated);

//        Group employees by age and count how many per age.
        Map<Integer, Long> employeesByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println("Employees by age: " + employeesByAge);

//        Find the average salary per department in a list of employees.
        Map<String, Double> averageSalaryByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary by department: " + averageSalaryByDepartment);

//        Flatten a list of lists into a single list.
        List<String> flattenedWords = nestedWords.stream().flatMap(List::stream).toList();
        System.out.println("Flattened words: " + flattenedWords);

//        Extract all unique characters from a list of words.
        Set<Character> uniqueCharacters = names.stream().filter(Objects::nonNull).flatMap(word -> word.chars().mapToObj(c -> (char) c)).collect(Collectors.toSet());
        System.out.println("Unique characters: " + uniqueCharacters);

//        Filter a list of Optionals and collect non-empty values.
        List<String> nonEmptyValues = names.stream().filter(Objects::nonNull).filter(s -> !s.trim().isEmpty()).toList();
        System.out.println("Non-empty values: " + nonEmptyValues);

//        Map a list of strings to their lengths.
        Map<String, Integer> wordLengths = names.stream().filter(Objects::nonNull).collect(Collectors.toMap(String::toLowerCase, String::length));
        System.out.println("Word lengths: " + wordLengths);

//        Return a list of uppercased words that start with “A”.
        List<String> uppercasedWords = names.stream().filter(Objects::nonNull).filter(w -> w.startsWith("A")).map(String::toUpperCase).toList();
        System.out.println("Uppercased words starting with 'A': " + uppercasedWords);

//        Sort a list of employees by salary then by name.
        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).toList();
        System.out.println("Sorted employees: " + sortedEmployees);

//        Find the second highest number in a list.
        Optional<Integer> secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second highest number: " + secondHighest.orElse(-1));

//        Find duplicate elements in a list of integers.
        List<Integer> duplicates = numbers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Duplicate elements: " + duplicates);

//        Remove null or empty strings from a list using stream.
        List<String> nonEmptyStrings = names.stream().filter(s -> s != null && !s.trim().isEmpty()).toList();
        System.out.println("Non-empty strings: " + nonEmptyStrings);

//        Partition students into pass/fail groups based on grade.
        Map<Boolean, List<Student>> passFailGroups = students.stream().collect(Collectors.partitioningBy(student -> student.getGrade() >= 60));
        System.out.println("Pass/fail groups: " + passFailGroups);

    }
}
