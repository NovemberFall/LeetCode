package HashTable._128_longestConsecutive;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int len = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    len += 1;
                }
                longest = Math.max(longest, len);
            }

        }
        return longest;
    }
}
