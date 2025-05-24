package _JavaAPI.ArrayList;

import java.util.ArrayList;
import java.util.List;

class Reverse_Adding {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(0, i);
        }
        System.out.println(res);

        System.out.println(0 % 2);
    }
}
