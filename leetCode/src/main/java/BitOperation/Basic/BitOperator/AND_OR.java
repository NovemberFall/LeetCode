package BitOperation.Basic.BitOperator;

public class AND_OR {
    public static void main(String[] args) {
        int twos = 0, ones = 0;
        // AND
        ones &= 2;
        System.out.println(ones);

        // OR
        twos |= ones;
        System.out.println(twos);
    }
}
