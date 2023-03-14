package HashTable._41_FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

class FirstMissingPositive_hashSet {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length + 1;
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }
}
