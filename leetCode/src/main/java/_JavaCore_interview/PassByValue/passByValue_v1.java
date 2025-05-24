package _JavaCore_interview.PassByValue;


import org.testng.annotations.Test;

class passByValue_v1 {

    @Test
    void testPassByValue() {
        int x = 10;
        changeValue(x);
        System.out.println(x); // Output: 10
    }

    private static void changeValue(int num) {
        num = 20;
    }


    @Test
    void testPassByObject() {
        StringBuilder sb = new StringBuilder("Hello");
        changeValue(sb);
        System.out.println(sb); // Output: Hello World
    }

    public static void changeValue(StringBuilder str) {
        str.append(" World");
    }


    @Test
    void testAssignNewValToStrInsideMethod() {
        StringBuilder sb = new StringBuilder("Hello");
        changeValue2(sb);
        System.out.println(sb); // Output: Hello
    }

    public static void changeValue2(StringBuilder str) {
        str = new StringBuilder("Goodbye");
    }
}
