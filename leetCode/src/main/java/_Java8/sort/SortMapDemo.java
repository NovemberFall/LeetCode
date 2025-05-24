package _Java8.sort;


import _Java8.Data.Employee;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class SortMapDemo {

	@Test
	void testSortMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		for (Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}








	@Test
	void testSortMap2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		for (Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}











	@Test
	void testSortMap3() {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		map.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("*********************************************");
		map.entrySet().stream().sorted(Entry.comparingByValue()).forEach(System.out::println);
	}












	/*
		https://docs.google.com/document/d/1UMx9LMImzzGaAbXexBNLikzUtn38V_pkh1gOwvJoANE/edit#bookmark=id.vj2sqgbejg1e

		map.keySet().stream()
		map.values().stream()
		map.entrySet().stream()
	 */
	@Test
	void testSortMap4() {
		Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		});

		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);
//		System.out.println(employeeMap);
		employeeMap.keySet().stream().forEach(System.out::println);
		employeeMap.values().stream().forEach(System.out::println);
		employeeMap.entrySet().stream().forEach(System.out::println);
	}











	/*
		map.keySet().stream()
		map.values().stream()
		map.entrySet().stream()
	*/
	@Test
	void testSortMap5() {
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) ->
				(int) (o1.getSalary() - o2.getSalary())
		);

		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		employeeMap.keySet().stream().forEach(System.out::println);
		employeeMap.values().stream().forEach(System.out::println);
		employeeMap.entrySet().stream().forEach(System.out::println);
	}













	@Test
	void testSortMap6() {
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) ->
				(int) (o1.getSalary() - o2.getSalary())
		);

		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		employeeMap.entrySet().stream().sorted(
				Entry.comparingByKey(Comparator.comparing(Employee::getSalary))
		).forEach(System.out::println);
		/*
		注意以上几句：
			- Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))
				- 这里Map 是一个interface, Entry is a nested interface, a member interface in Map
				- public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> comparingByKey()
					- comparingByKey() 是一个 static method
		 */
	}













	@Test
	void testSortMap7() {
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) ->
				(int) (o1.getSalary() - o2.getSalary())
		);

		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		employeeMap.entrySet().stream().sorted(
				Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())
		).forEach(System.out::println);
	}
}
