package Self_Training.Java8;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class stream_dedup {

    @Test
    void testDeDup() {
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 6));

        List<Integer> listWithOutDuplicates = numList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithOutDuplicates);
    }

    @Test
    void testDeDupStr() {
        String str = "Hello World";
        String res = Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
        System.out.println(res);
    }
}
