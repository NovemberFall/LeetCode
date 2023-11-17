package Java8.Streams.Dedup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


public class streamDedup {
    public static void main(String[] args) {
        // ArrayList with deduplicate elements
        List<Integer> numsList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 6));
        List<Integer> listWithoutDuplicates = numsList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }

    @Test
    void dedupChars() {
        String str = "Hello World ";
        String res = Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
        System.out.println(res);
    }
}
