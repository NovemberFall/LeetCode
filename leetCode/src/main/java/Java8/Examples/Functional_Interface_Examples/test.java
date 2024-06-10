package Java8.Examples.Functional_Interface_Examples;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class test {
    @Test
    void testPredicate() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // [2, 4, 6]
    }


    @Test
    void testCosumer() {
        Consumer<String> printString = System.out::println;
        List<String> strings = Arrays.asList("Hello", "World");
        strings.forEach(printString); // Hello
                                      // World
    }
}
