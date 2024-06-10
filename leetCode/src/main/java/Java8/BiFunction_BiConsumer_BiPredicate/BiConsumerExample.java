package Java8.BiFunction_BiConsumer_BiPredicate;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class BiConsumerExample implements BiConsumer<String, Integer> {
    @Override
    public void accept(String s1, Integer i2) {
        System.out.println("input 1" + s1 + ": input 2 " + i2);
    }






    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = new BiConsumerExample();
        biConsumer.accept("java8", 53000);
    } // input 1 java8: input 2 53000






    @Test
    void testBiConsumer() {
        BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s1, Integer i2) {
                System.out.println(s1 + ":" + i2);
            }
        };

        biConsumer1.accept("accept", 143);
    }






    @Test
    void testBiConsumer_lambda() {
        BiConsumer<String, Integer> biConsumer2 = (o1, o2) -> System.out.println(o1 + ":" + o2);
        biConsumer2.accept("YouTube", 786);
    }






    @Test
    void testBiConsumer_forEach() {
        BiConsumer<String, Integer> biConsumer2 = (o1, o2) -> System.out.println(o1 + ":" + o2);

        Map<String, Integer> map = new HashMap<>();
        map.put("Jack", 5000);
        map.put("Tim", 15000);
        map.put("Tony", 12000);

        map.forEach(biConsumer2);
    }








    @Test
    void testBiConsumer_forEach2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jack", 5000);
        map.put("Tim", 15000);
        map.put("Tony", 12000);

//        map.entrySet().stream().forEach(System.out::println);
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}




















