package _Java8.BiFunction_BiConsumer_BiPredicate;

import org.testng.annotations.Test;

import java.util.function.BiPredicate;


public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        System.out.println(biPredicate.test("BiPredicate","BiPredicate"));// true
    }






    @Test
    void testBiPredicateLambda() {
        BiPredicate<String, String> biPredicate = (o1, o2) -> o1.equals(o2);
        System.out.println(biPredicate.test("BiPredicate","BiPredicate"));
    }






    @Test
    void testBiPredicate_and() {
        BiPredicate<String, String> equalsPredicate = (o1, o2) -> o1.equals(o2);
        BiPredicate<String, String> lengthPredicate = (s1, s2) -> s1.length() == s2.length();

        boolean output = lengthPredicate.and(equalsPredicate).test("hello", "hello");
        System.out.println("output :" + output);
    }






    @Test
    void testBiPredicate_or() {
        BiPredicate<String, String> equalsPredicate = (o1, o2) -> o1.equals(o2);
        BiPredicate<String, String> lengthPredicate = (s1, s2) -> s1.length() == s2.length();

        boolean orOutput = lengthPredicate.or(equalsPredicate).test("hello", "hello");
        System.out.println("orOutput :" + orOutput);
    }
}
