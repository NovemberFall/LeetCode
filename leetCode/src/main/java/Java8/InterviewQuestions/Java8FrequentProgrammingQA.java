package Java8.InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 <a href="https://www.youtube.com/watch?v=1Ps5F1PU72M&list=PLVz2XdJiJQxzrdrpglCv_nWIO5CDIqOVj&index=18">youTube video</a>


 1. Java program to count the occurrence of each character in a string
 Ex: ilovejavaprogram

 */
class Java8FrequentProgrammingQA {

    @Test
    void testSplit() {
        String input = "ilovejavaprogram";
        String[] res = input.split("");
        System.out.println(Arrays.toString(res));
    }

    @Test
    void testGroupFunction() {
        String input = "ilovejavaprogram";
        String[] res = input.split("");

        Map<String, List<String>> map = Arrays.stream(res)
                .collect(Collectors.groupingBy(s -> s));
        System.out.println(map);
    }


    @Test
    void testGroupingWithCounting() {
        String input = "ilovejavaprogram";
        String[] res = input.split("");

        Map<String, Long> map = Arrays.stream(res)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
