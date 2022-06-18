package Air_Invaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {

    public static int maxPlanes(List<Integer> startHeight, List<Integer> descentRate) {
        int n = startHeight.size();
        int count = 1;
        int currHeight = 0;
        for (int i = 1; i < n; i++) {
            currHeight = startHeight.get(i) - i * descentRate.get(i);
            System.out.println("Current Height: "+ currHeight);

            count = (currHeight > 0) ? count + 1 : count;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> startHeight = new ArrayList<>(Arrays.asList(4, 3, 1));
        List<Integer> descentRate = new ArrayList<>(Arrays.asList(3, 2, 1));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(4, 3));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(2, 2));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(2, 4, 3));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(2, 2, 2));

//        List<Integer> startHeight = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 8));
//        List<Integer> descentRate = new ArrayList<>(Arrays.asList(1, 2, 2, 1, 2));
        System.out.println(maxPlanes(startHeight, descentRate));
    }
}




