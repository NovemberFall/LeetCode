package string.split;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "/a/b/c/d";
        String [] str = s.split("/");
        System.out.println(Arrays.toString(str));
        System.out.println();

        s = "a/b/c/d/";
        String[] str1 = s.split("/");
        System.out.println(Arrays.toString(str1));

        System.out.println();
        s = ":abc:d:eee:";
        String[] str2 = s.split(":");
        System.out.println(Arrays.toString(str2));
    }
}
