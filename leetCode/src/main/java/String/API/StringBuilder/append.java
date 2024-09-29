package String.API.StringBuilder;

import java.util.ArrayList;
import java.util.List;

class append {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        char[][] board = new char[][]{{'.', 'Q', '.', '.'}, {'Q', '.', '.', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        for (char[] c : board) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            res.add(sb.toString());
        }
        System.out.println(res);
    }
}
