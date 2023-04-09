package Java8.Data;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


public class TaxService {

	@Test
	void test1() {
		System.out.println(evaluateTaxUsers1("non tax"));
	}
	private List<Employee> evaluateTaxUsers1(String input) {
		if (input.equalsIgnoreCase("tax")) {
			return DataBase.getEmployees()
					.stream()
					.filter(emp -> emp.getSalary() > 500000)
					.collect(Collectors.toList());
		} else {
			return DataBase.getEmployees()
					.stream()
					.filter(emp -> emp.getSalary() < 500000)
					.collect(Collectors.toList());
		}
	}





	public static List<Employee> evaluateTaxUsers(String input) {
		return (input.equalsIgnoreCase("tax"))
				? DataBase.getEmployees().stream().filter(emp -> emp.getSalary() > 500000).collect(Collectors.toList())
				: DataBase.getEmployees().stream().filter(emp -> emp.getSalary() <= 500000)
						.collect(Collectors.toList());

	}

	public static void main(String[] args) {
		System.out.println(evaluateTaxUsers("tax"));
	}
}
