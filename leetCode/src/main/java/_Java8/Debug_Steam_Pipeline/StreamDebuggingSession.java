package _Java8.Debug_Steam_Pipeline;


import _Java8.Data.Employee;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;


/*
    https://novemberfall.github.io/Java-ObjectOriented/#/java8/debug
 */
public class StreamDebuggingSession {
    @Test
    void testStreamDebugging() {
        List<String> names = EmployeeDatabase.getEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > 40000)
                .map(Employee::getName)
//                .distinct()
                .sorted()
                .skip(0)
//                .limit(3)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
