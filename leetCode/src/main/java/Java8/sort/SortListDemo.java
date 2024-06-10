package Java8.sort;


import Java8.Data.DataBase;
import Java8.Data.Employee;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortListDemo {

	@Test
	void testSortList() {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);

		Collections.sort(list);//ascending
		Collections.reverse(list);//descending
		System.out.println(list);

		list.stream().sorted().forEach(e -> System.out.println(e));//ascending
	}







	@Test
	void testSortListReverse() {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(3);
		list.add(12);
		list.add(4);

		Collections.sort(list);//ascending
		Collections.reverse(list);//descending
		System.out.println(list);

		list.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println(e));//descending
	}













	@Test
	void testSortList2() {
		List<Employee> employees = DataBase.getEmployees();
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		});
		employees.stream().forEach(System.out::println);
	}



















	@Test
	void testSortList3() {
		List<Employee> employees = DataBase.getEmployees();

		Collections.sort(employees, (e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));

		employees.stream().forEach(System.out::println);
	}











	@Test
	void testSortList4() {
		List<Employee> employees = DataBase.getEmployees();

		Collections.sort(employees, (e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));

//        System.out.println(employees);

		employees.stream().sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
				.forEach(System.out::println);
	}












	@Test
	void testSortList5() {
		List<Employee> employees = DataBase.getEmployees();

		employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary()))
				.forEach(System.out::println);
	}









	public static void main(String[] args) {

		List<Employee> employees = DataBase.getEmployees();

		employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);

	}
}
