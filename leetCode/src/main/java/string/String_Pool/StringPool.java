package string.String_Pool;

import org.junit.jupiter.api.Test;

public class StringPool {

    /*
    Pooling for String objects
    There is no need for
     */
    @Test
    public void string_Interning() {
        String constantString1 = "string";
        String constantString2 = "string";
        System.out.println(constantString1 == constantString2);
    }


    /*
       When we create a String via the new operator, the Java compiler will create a new object and
       store it in the heap space reserved for the JVM.

       Every String created like this will point to a different memory region with its own address.
       Let’s see how this is different from the previous case:
     */
    @Test
    void strings_Allocated_Using_Constructor() {
        String constantString = "gradle";
        String newString = new String("gradle");
        System.out.println(constantString == newString);
    }



}
