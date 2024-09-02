package JavaAPI.TreeSet;

import java.util.TreeSet;

class ceiling {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(9);
        treeSet.add(11);
        treeSet.add(15);
        treeSet.add(20);

        Integer element = 5;
        Integer ceiling = treeSet.ceiling(element);
        System.out.println(treeSet);
        System.out.println("The ceiling of " + element + " is " + ceiling); // `>= 5` 的最小数
    }
}
