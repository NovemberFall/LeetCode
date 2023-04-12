package JavaCore.Generics._8_Wildcards._2_UnboundedWildcards;

import java.util.List;
import java.util.Arrays;

/*
The question mark (?), represents the wildcard, stands for unknown type in generics.
There may be times when any object can be used when a method can be implemented using functionality
                provided in the Object class or When the code is independent of the type parameter.

To declare an Unbounded Wildcard parameter, list the ? only.
*/

public class GenericsTester {
    public static void printAll(List<?> list) {
        for (Object item : list) {
            System.out.println(item + " ");
        }
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
