package Java8.Comsumer_Predicate_Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;


/**

public class PredicateDemo implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if (integer % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = new PredicateDemo();
        System.out.println(predicate.test(7));
    }
}
 */


public class PredicateDemo {

	@Test
	void testPredicate() {
		Predicate<Integer> predicate = (t) -> {
			return t % 2 == 0;
		};

		System.out.println(predicate.test(8));
	}




	@Test
	void testPredicate2(){
		Predicate<Integer> predicate = (t) -> {
			return t % 2 == 0;
		};

		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		list2.stream().filter(predicate).forEach(e -> System.out.println("Printing Even: " + e));
	}



	//use lambda expression
	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		list1.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("print  Even: " + t));
	}
}
