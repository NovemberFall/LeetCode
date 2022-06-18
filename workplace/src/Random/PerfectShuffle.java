package Random;

import java.util.Random;

public class PerfectShuffle {
    public static void main(String[] args) {
//        for (int i = 0; i < 52; i++) {
//            System.out.println( Math.random() );
////            System.out.println( (int) (Math.random() * (i + 1)) );
//        }

//        double random = Math.random();
//        System.out.println(random);

        for (int i = 0; i < 52; i++) {
            System.out.println(new Random().nextInt(52));
        }
    }
}
