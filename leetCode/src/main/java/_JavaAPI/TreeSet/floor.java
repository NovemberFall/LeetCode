package _JavaAPI.TreeSet;

import java.util.TreeSet;

class floor {
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

        Integer element = 10;
        Integer floor = treeSet.floor(element);
        System.out.println(treeSet);
        System.out.println("The floor of " + element + " is " + floor);

        ////////////////////////////////////
        treeSet.clear();
        treeSet.add(5);
        System.out.println(treeSet.ceiling(5));
    }
}
