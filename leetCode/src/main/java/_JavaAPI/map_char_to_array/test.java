package _JavaAPI.map_char_to_array;

class test {
    public static void main(String[] args) {
        int[] map = new int[128];
        System.out.println(map['c']); // The ASCII value (or Unicode code point) for 'c' is 99.
        /*
            This accesses the map array at index 99.
            Equivalent to map[99].
        */
    }
}
