import java.util.*;
import java.util.stream.Collectors;

public class Question7 {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ahmed", "IT", 10000),
                new Employee("Mohamed", "IT", 18000),
                new Employee("Sara", "HR", 9000),
                new Employee("Omar", "HR", 14000),
                new Employee("Ali", "Finance", 20000)
        );

        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.maxBy(
                                Comparator.comparingDouble(Employee::salary)
                        )
                ));

        result.forEach((department, employee) ->
                System.out.println(department + " = " + employee.get().name())
        );
    }
}