package _JavaCore_interview.Immutable_Object;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class test1 {
    public static void main(String[] args) {
        String str = "Hello, world!";
        System.out.println(System.identityHashCode(str));// 1304836502
        str = "How are you?";
        System.out.println(System.identityHashCode(str));// 225534817
    }

    @Test
    void testStringPool() {
        String constantString1 = "Baeldung";
        System.out.println(System.identityHashCode(constantString1));// 775931202
        String constantString2 = "Baeldung";
        System.out.println(System.identityHashCode(constantString2));// 775931202

        assertEquals(constantString1, constantString2);// true
    }
}
