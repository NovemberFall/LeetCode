package Concurrency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return new ArrayList<String>();
        }
        Map<String, Integer> freqMap = getFreqMap(words);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return e2.getKey().compareTo(e1.getKey());
                } else {
                    return e1.getValue() - e2.getValue();
                }
            }
        });

        // //If using Lambda =>
        // PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(
        //     (a, b)->(
        //         (a.getValue() == b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue();
        //     );
        // );

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //concurrency example:
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (!entry.getKey().equals("is")) {
                freqMap.remove(entry.getKey());
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }
        return result;

    }

    //convert String array to HashMap
    private Map<String, Integer> getFreqMap(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : words) {
            Integer val = freqMap.get(s);
            if (val == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, val + 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        topKFrequent tkf = new topKFrequent();
        tkf.topKFrequent(words, 4);
    }
}
