package Math._12_IntegerToRoman;

import java.util.HashMap;

class integerToRoman_II {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int count = 0;
        StringBuilder res = new StringBuilder();
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < arr.length; i++) {
            if (num / arr[i] > 0) {
                count = num / arr[i];
                for (int j = 0; j < count; j++) {
                    res.append(map.get(arr[i]));
                }
                num = num % arr[i];
            }
        }
        return res.toString();
    }
}
