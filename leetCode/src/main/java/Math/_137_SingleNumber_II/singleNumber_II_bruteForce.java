package Math._137_SingleNumber_II;

import java.util.HashMap;
import java.util.Map;

class singleNumber_II_bruteForce {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return freq.entrySet()
                .stream()
                .filter(e -> e.getValue() < 3)
                .findFirst()
                .map(e -> e.getKey())
                .orElse(-1);
    }
}
