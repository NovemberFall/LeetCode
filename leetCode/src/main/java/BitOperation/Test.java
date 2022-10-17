package BitOperation;

public class Test {
    public static void main(String[] args) {
        int bit = 0;
        int res = bit & 1;
        System.out.println(res);
        res = bit >> 1;
        System.out.println(res);
        bit = 1;
        res = bit & 1;
        System.out.println(res);
        res = bit >> 1;
        System.out.println(res);
    }
}
