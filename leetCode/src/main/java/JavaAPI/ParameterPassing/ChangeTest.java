package JavaAPI.ParameterPassing;


import org.testng.annotations.Test;

public class ChangeTest {
    private static void changeIntValue(int x) {
        x = 10;
    }

    private static void changeSimpleValue1(Simple simple) {
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static Simple changeSimpleValue3(Simple simple) {
        Simple newSimple = new Simple(10);
        return newSimple;
    }

    private static void changeSimpleValue2(Simple simple) {
        simple.value = 10;
    }


    @Test
    void test_hangeSimpleValue1() {
        Simple originalSimple = new Simple(5);
        changeSimpleValue1(originalSimple);
        System.out.println(originalSimple.value);
    }

    @Test
    void test_hangeSimpleValue2() {
        Simple originalSimple = new Simple(5);
        changeSimpleValue2(originalSimple);
        System.out.println(originalSimple.value);
    }

    @Test
    void test_hangeSimpleValue3() {
        Simple originalSimple = new Simple(5);
        originalSimple = changeSimpleValue3(originalSimple);
        System.out.println(originalSimple.value);
    }

    @Test
    void test_changeIntValue() {
        int x = 5;
        changeIntValue(x);
        System.out.println(x);
    }
}
