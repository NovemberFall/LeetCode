package JavaAPI.TreeSet;

import java.util.TreeSet;

class PrintElementsWithTreeSet_havingCustomClassObjects {
    static class Element implements Comparable<Element>{

        private int id;

        public Element(int id){
            this.id = id;
        }

        public int getId(){
            return this.id;
        }

        public int compareTo(Element otherUser) {
            return this.getId() - otherUser.getId();
        }

        @Override
        public String toString() {
            return "Element => " + getId();
        }
    }
    public static void main(String[] args) {
        TreeSet<Element> tSetElements = new TreeSet<>();
        tSetElements.add(new Element(1));
        tSetElements.add(new Element(2));
        tSetElements.add(new Element(5));
        tSetElements.add(new Element(9));
        tSetElements.add(new Element(11));
        tSetElements.add(new Element(77));

        System.out.println(tSetElements);
    }
}
