package JavaAPI.CompareTwoList_with_Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class compareTwoList {
    @Test
    void compareTwoListWithJava8() {
        List<Integer> list = Arrays.asList(57, 55, 44, 44, 33, 33, 20, 50, 5, 36, 60, 20, 10, 30);
        boolean res = list
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .equals(list);
        System.out.println(res);
    }

    @Test
    void filterListWithForLoop() {
        List<Integer> list = Arrays.asList(57, 55, 44, 44, 33, 33, 20, 50, 5, 36, 60, 20, 10, 30);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                System.out.println(false);
                break;
            }
        }
    }
}
