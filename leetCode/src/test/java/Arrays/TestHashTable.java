package Arrays;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestHashTable {
    @Test
    void testHash() {
        Set<Integer> set = new HashSet<>();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            System.out.println(num);
        }
    }
}
