package PreSum;

import java.util.Random;
import java.util.Arrays;

public class randomPickWithWeight {
    Random random;
    int[] wSums;

    public randomPickWithWeight(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; ++i)
            w[i] += w[i - 1];
        this.wSums = w;
        System.out.println(Arrays.toString(w));
    }

    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len - 1]) + 1;
        int left = 0, right = len - 1;
        // search position
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (wSums[mid] == idx)
                return mid;
            else if (wSums[mid] < idx)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3, 4};
        randomPickWithWeight rpw = new randomPickWithWeight(w);

    }
}
