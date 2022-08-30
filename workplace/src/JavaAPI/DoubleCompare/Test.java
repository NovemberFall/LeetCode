package JavaAPI.DoubleCompare;

public class Test {
    public static void main(String[] args) {
        double a = 3.14;
        double b = 2.16;
        System.out.println(Double.compare(a, b));
        boolean flag = a > b;
        System.out.println(flag);

        double x = Math.abs(a - b);
        System.out.println(x);
    }
}
