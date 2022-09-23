package Generics.Wildcards.UnboundedWildcards;

import java.util.List;
import java.util.Arrays;

/*
The question mark (?), represents the wildcard, stands for unknown type in generics.
There may be times when you'll want to restrict the kinds of types that are allowed to be passed to a type parameter.
For example, a method that operates on numbers might only want to accept instances of Integer
    or its superclasses like Number.

To declare a lower bounded Wildcard parameter, list the ?, followed by the super keyword, followed by its lower bound.
*/

public class GenericsTester {
    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }

    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        printAll(integerList);
        List<Double> doubleList = Arrays.asList(1.2, 2.3, 3.5);
        printAll(doubleList);
        List<String> strList = Arrays.asList("Unbounded", "WildCards");
        printAll(strList);
    }
}
