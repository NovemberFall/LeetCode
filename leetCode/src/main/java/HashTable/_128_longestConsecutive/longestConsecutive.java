package HashTable._128_longestConsecutive;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int len = 0;
                while (set.contains(n + len)) {
                    len += 1;
                }
                longest = Math.max(len, longest);
            }

        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = longestConsecutive(nums);
        System.out.println(res);

        int[] nums1 = new int[]{100,4,200,1,3,2};
        res = longestConsecutive(nums1);
        System.out.println(res);
    }
}
