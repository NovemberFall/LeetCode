package BitOperation.Basic.BitOperator;

public class Bit {
    //print binary representation of an int value
    public static void printBinary(int value) {
        System.out.println(value + " : ");
        StringBuilder builder = new StringBuilder();
        for (int shift = 31; shift >= 0; shift--) {
            builder.append((value >>> shift) & 1);
        }
        System.out.println(builder.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        // 0
        int a = 0;
        printBinary(a);

        // positive number
        a = 5;
        printBinary(a);

        // Negative number
        a = -5;
        printBinary(a);

//        a = Integer.MIN_VALUE;
        a = 0x80000000;
        printBinary(a);
        // 10000000 00000000 00000000 00000000

//         a = Integer.MAX_VALUE;
        a = 0x7fffffff;
        printBinary(a);
        // 11111111 11111111 11111111 11111111


        // signed shift - leftmost bit depends on previous leftmost bit
        int b = a >> 5;
        printBinary(b);

        // unsigned shift - leftmost bit "0"
        b = a >>> 5;
        printBinary(b);
    }
}
