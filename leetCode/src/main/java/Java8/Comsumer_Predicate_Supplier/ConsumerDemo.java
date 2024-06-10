package Java8.Comsumer_Predicate_Supplier;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerDemo {

    @Test
    void testConsumer() {
        Consumer<Integer> consumer = t -> System.out.println("Printing  : " + t);
        consumer.accept(15);
    }



	@Test
	void testConsumer2() {
		Consumer<Integer> consumer = t -> System.out.println("Printing  : " + t);
		consumer.accept(100);

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		list1.stream().forEach(consumer);
	}


    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

        list1.stream().forEach(t -> System.out.println("print  : " + t));

    }
}
