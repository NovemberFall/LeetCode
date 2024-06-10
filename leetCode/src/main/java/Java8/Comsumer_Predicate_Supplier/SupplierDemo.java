package Java8.Comsumer_Predicate_Supplier;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;



/**

public class SupplierDemo implements Supplier<String> {
    @Override
    public String get() {
        return "Hi Java 8 => functional interface";
    }

    public static void main(String[] args) {
        Supplier<String> supplier = new SupplierDemo();
        System.out.println(supplier.get());
    }
}

// Hi Java 8 => functional interface

 */

public class SupplierDemo {

	@Test
	void testSupplier() {
		Supplier<String> supplier = () -> "Hi Java 8 => functional interface";
		System.out.println(supplier.get());
		List<String> list3 = Arrays.asList("hello", "world");
		System.out.println(list3.stream().findAny().orElseGet(supplier));
	}





	//注意以下代码为什么会invoke supplier的值？学会看源代码:
	@Test
	void testSupplier2() {
		Supplier<String> supplier = () -> "Hi Java 8 => functional interface";
		List<String> list3 = Arrays.asList();
		System.out.println(list3.stream().findAny().orElseGet(supplier));
	}



	public static void main(String[] args) {

		List<String> list1 = Arrays.asList();
		System.out.println(list1.stream().findAny().orElseGet(() -> "Hi viewers"));
	}
}
