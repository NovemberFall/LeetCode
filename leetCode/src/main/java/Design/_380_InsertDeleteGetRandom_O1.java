package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class _380_InsertDeleteGetRandom_O1 {
    private Map<Integer, Integer> indexMap;
    private List<Integer> list;
    private Random random;

    public _380_InsertDeleteGetRandom_O1() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /*  Inserts an item val into the set if not present. Returns true if the item was not present,
    false otherwise. */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }

    /*  Removes an item val from the set if present. Returns true if the item was present,
    false otherwise. */
    public boolean remove(int val) {
        Integer index = indexMap.get(val);
        if (index == null) {
            return false;
        }
        int toDelete = list.get(index);
        if (index != list.size() - 1) {
            swap(list, index, list.size() - 1);
            indexMap.put(list.get(index), index);
        }
        indexMap.remove(toDelete);
        list.remove(list.size() - 1);
        return true;
    }

    private void swap(List<Integer> list, Integer i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /* Returns a random element from the current set of elements */
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
