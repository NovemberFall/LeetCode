package Java8.BiFunction_BiConsumer_BiPredicate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;


public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {
    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1, list2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }







    @Test
    void testBiFunction() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = new BiFunctionExample();
        List<Integer> list1 = Stream.of(1, 3, 4, 6, 7, 9, 19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11, 3, 43, 6, 7, 19).collect(Collectors.toList());
        System.out.println("Traditional approach : " + biFunction.apply(list1, list2));
    }










    @Test
    void testBiFunction2() {
        List<Integer> list1 = Stream.of(1, 3, 4, 5, 6, 7, 9, 19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11, 3, 53, 6, 7, 19).collect(Collectors.toList());

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 =
                new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
                    @Override
                    public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
                        return Stream.of(l1, l2)
                                .flatMap(e -> e.stream())
                                .distinct()
                                .collect(Collectors.toList());
                    }
                };
        System.out.println("anonymous implementation : " + biFunction1.apply(list1, list2));
    }











    @Test
    void testBiFunction3() {
        List<Integer> list1 = Stream.of(-4, -5, 1, 3, 4, 5, 6, 7, 9, 19, -2, -1)
                .collect(Collectors.toList());
        List<Integer> list2 = Stream.of(-1, -2, -10, -99, 11, 3, 53, 6, 7, 19)
                .collect(Collectors.toList());

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = (l1, l2) -> {
            return Stream.of(l1, l2)
                    .flatMap(e -> e.stream())
                    .distinct()
                    .collect(Collectors.toList());
        };

        System.out.println("Lambda approach : " + biFunction2.apply(list1, list2));
    }









    @Test
    void testBiFunction_replaceAll() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tim", 5000);
        map.put("James", 15000);
        map.put("Mike", 12000);

        BiFunction<String, Integer, Integer> increaseSalaryBiFunction = new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String key, Integer value) {
                return value + 1000;
            }
        };

        map.replaceAll(increaseSalaryBiFunction);
        System.out.println(map);
    }








    @Test
    void testBiFunction_replaceAll_lambda() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tim", 5000);
        map.put("James", 15000);
        map.put("Mike", 12000);

        BiFunction<String, Integer, Integer> increaseSalaryBiFunction = (key, value) -> {
            return value + 2000;
        };

        map.replaceAll(increaseSalaryBiFunction);
        System.out.println(map);
    }











    @Test
    void testBiFunction_AddThen() {
        List<Integer> list1 = Stream.of(1, 3, 4, 6, 7, 9, 19, -1, -2, -55, -9, -3, -4)
                .collect(Collectors.toList());
        List<Integer> list2 = Stream.of(-1, -2, 11, 3, -99, 43, 6, 7, 19, -4, -3)
                .collect(Collectors.toList());


        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = (l1, l2) -> {
            return Stream.of(l1, l2)
                    .flatMap(integers -> integers.stream())
                    .distinct()
                    .collect(Collectors.toList());
        };

        Function<List<Integer>, List<Integer>> sortedFunction = (lists) -> lists
                .stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Function Lambda approach : " +
                biFunction2.andThen(sortedFunction).apply(list1, list2));
    }
}
