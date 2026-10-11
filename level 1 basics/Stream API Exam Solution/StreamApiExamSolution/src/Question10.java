import java.util.*;
import java.util.stream.Collectors;

public class Question10 {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ahmed", "IT", 10000),
                new Employee("Mohamed", "IT", 18000),
                new Employee("Ali", "IT", 15000),
                new Employee("Omar", "IT", 22000),

                new Employee("Sara", "HR", 12000),
                new Employee("Mona", "HR", 16000),
                new Employee("Nour", "HR", 14000),
                new Employee("Hana", "HR", 9000),

                new Employee("Khaled", "Finance", 20000),
                new Employee("Youssef", "Finance", 25000),
                new Employee("Mostafa", "Finance", 18000)
        );

        Map<String, List<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(
                                                Comparator.comparingDouble(Employee::salary)
                                                        .reversed()
                                                        .thenComparing(Employee::name)
                                        )
                                        .limit(3)
                                        .toList()
                        )
                ));

        result.forEach((department, list) -> {

            System.out.println(department + ":");

            list.forEach(employee ->
                    System.out.println(
                            employee.name() + " = " + employee.salary()
                    )
            );

            System.out.println();
        });
    }
}