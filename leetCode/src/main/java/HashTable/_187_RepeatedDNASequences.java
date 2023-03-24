package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), res = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String tenDna = s.substring(i, i + 10);
            if (seen.contains(tenDna)) {
                res.add(tenDna);
            }
            seen.add(tenDna);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        _187_RepeatedDNASequences rns = new _187_RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = rns.findRepeatedDnaSequences(s);
        System.out.println(res); // [AAAAACCCCC, CCCCCAAAAA]
    }
}

