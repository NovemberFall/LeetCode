package Java8.Examples;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class stream_dedup {
    public static void main(String[] args) {
        // ArrayList with duplicate elements
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 6));

        List<Integer> listWithoutDuplicates = numbersList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates); //[1, 2, 3, 4, 5, 6]
    }

    @Test
    void dedupChars() {
        String str = "Hello World";
        String result = Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
        System.out.println(result); // prints "Helo Wrd"
    }
}
