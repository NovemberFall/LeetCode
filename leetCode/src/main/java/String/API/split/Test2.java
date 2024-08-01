package String.API.split;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String str = " 3+5 / 2 ";
        String[] strs = str.split(" ");
        System.out.println(Arrays.toString(strs));
    }
}
