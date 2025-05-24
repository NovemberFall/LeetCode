package _Java8.Debug_Steam_Pipeline;


import _Java8.Data.Employee;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {
    public static List<Employee> getEmployees() {
        return Stream.of(
                new Employee(176, "Roshan", "IT", 600000),
                new Employee(388, "Bikash", "CIVIL", 900000),
                new Employee(470, "Bimal", "DEFENCE", 500000),
                new Employee(624, "Sourav", "CORE", 400000),
                new Employee(284, "Prakash", "SOCIAL", 1200000),
                new Employee(103, "Sam", "QA", 40000),
                new Employee(104, "John", "DEV", 80000),
                new Employee(105, "Ajay", "DEV", 90000),
                new Employee(106, "Sam", "UI", 70000),
                new Employee(236, "Ram", "UI", 85000),
                new Employee(237, "Ram", "Mng", 80000),
                new Employee(299, "Bala", "Mng", 200000)
        ).collect(Collectors.toList());
    }
}
