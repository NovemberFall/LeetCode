package _Java8.Examples;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class removeDuplicatesFromCollection {
    public static void main(String[] args) {
        List<Integer> listWithoutDuplicates = Stream
                .of(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
        //[1, 2, 3, 4, 5, 6, 7, 8]

        HashSet<Integer> set = new HashSet();
    }
}
