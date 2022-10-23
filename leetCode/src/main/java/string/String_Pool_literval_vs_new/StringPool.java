package string.String_Pool_literval_vs_new;

import org.junit.jupiter.api.Test;

public class StringPool {

    /*      Pooling for String objects
        There is no need for maintaining several copies of String objects with the same literal,
        since String objects are immutable.

        Usually compiler and JVM will optimize for the number of String objects created,
        it will maintain an intern area in HEAP, for the same String literal it will only have
        one String Object associated.
     */
    @Test
    public void string_Interning() {
        String constantString1 = "string";
        String constantString2 = "string";
        System.out.println(constantString1 == constantString2);
    }


    /*
        The String objects created with `new` will not use intern pool
     */
    @Test
    void strings_Allocated_Using_Constructor() {
        String constantString = "gradle";
        String newString = new String("gradle");
        System.out.println(constantString == newString); // False

        String third = new String("Baeldung");
        String fourth = new String("Baeldung");
        System.out.println(third == fourth); // False
    }






    /*
        The optimization is at compile time, the literals will be concatenated if
        possible before getting the String object
     */
    @Test
    void concatenation() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b"; // compile time concat, "ab"

        System.out.println(s3 == "a" + "b"); // true
        System.out.println(s3 == s1 + "b");  // false, s1.concat("b")
        System.out.println(s3 == s1 + s2); // false, s1.concat(s2);
    }






    @Test
    void concatenation2() {
        String s1 = "abc";
        String s2 = "def";

        String s3 = s1.concat(s2); // this will create a new String object rather than change the value of s1 or s2
        System.out.println(s1); // "abc"
        System.out.println(s3); // "abcdef"

        s1 = "abc" + "def"; // s1 = "abcdef", compile time concatenation
        System.out.println(s1);
    }
}
