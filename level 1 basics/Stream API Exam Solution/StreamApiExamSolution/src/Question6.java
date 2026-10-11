import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question6 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ahmed", "IT", 10000);
        Employee employee2 = new Employee("Mohamed", "IT", 15000);
        Employee employee3 = new Employee("Sara", "HR", 8000);
        Employee employee4 = new Employee("Omar", "HR", 12000);
        Employee employee5 = new Employee("Ali", "Finance", 20000);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        Map<String,Double> result = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(result);


    }
}
