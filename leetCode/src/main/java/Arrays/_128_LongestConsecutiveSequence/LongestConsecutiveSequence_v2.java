package Arrays._128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence_v2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left)) {
                left--;
            }
            while (set.remove(right)) {
                right++;
            }
            longest = Math.max(longest, right - left - 1);
            if (set.isEmpty()) {
                return longest;
            }
        }
        return longest;
    }
}

/*
l = 2, r = 4
        [0      0       2       3       4       5       100]
                        l               r


l = 1, r = 4
        [0      0       2       3       4       5       100]
                    l                   r


l = 1, r = 5
        [0      0       2       3       4       5       100]
                    l                           r


l = 1, r = 6
        [0      0       2       3       4       5       100]
                    l                               r

   length = 6 - 1 - 1 = 4
 */
