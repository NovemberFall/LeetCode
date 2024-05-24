package Arrays._347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements_followUp {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freIndex = entry.getValue(); // frequency ==> Index
            freq[freIndex].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                res.add(num);
                if (res.size() == k) {
                    return res.stream().mapToInt(integer -> integer).toArray();
                }
            }
        }
        return new int[]{};
    }
}
