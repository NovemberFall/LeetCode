package phone_OA_OnSite.AirBnb.Air_Invaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public static int maxPlanes(List<Integer> startHeight, List<Integer> descentRate) {
        int n = startHeight.size();

        int [] roundsArr = new int[n];

        //if the remainder
        for (int i = 0; i < n; i++) {
            int t = (startHeight.get(i) % descentRate.get(i) > 0) ? 1 : 0;
            roundsArr[i] = (startHeight.get(i) / descentRate.get(i)) + t;
        }

        Arrays.sort(roundsArr);
//        for (int a : roundsArr) {
//            System.out.println(a);
//        }
        System.out.println("=============================");

        int round = 1;
        for (int i = 0; i < n; i++) {
            if (roundsArr[i] > round) {
                round++;
            }
        }
        return round;
    }

    public static void main(String[] args) {
        List<Integer> startHeight = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 8));
        List<Integer> descentRate = new ArrayList<>(Arrays.asList(1, 2, 2, 1, 2));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(2, 4, 3));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(2, 2, 2));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(4, 3, 1));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(3, 2, 1));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(4, 3));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(2, 2));

        int res = maxPlanes(startHeight, descentRate);
        System.out.println(res);
    }
}
