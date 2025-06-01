package DFS.combin_22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*     n = 2
                                      " "
                                   left=0 right=0
                          (                            )  //cut this branch
                   left=1 right=0                 left=0 right=1
                  ((                                  ()
           left=2 right=0                          left=1 right=1
          (((            (()                     ()(           ())  // cut
      l=3 r=0         l=2 r=1                  l=2 r=1
                            (())                     ()()
                            l=2 r=2                  l=2 r=2
 */
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder soluPrefix = new StringBuilder();
        dfs(soluPrefix, 0, 0, n, res);
        return res;
    }

    private void dfs(StringBuilder soluPrefix, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(soluPrefix.toString());
            return;
        }
        if (left < n) {
            soluPrefix.append("(");
            dfs(soluPrefix, left + 1, right, n, res);
            soluPrefix.deleteCharAt(soluPrefix.length() - 1);
        }

        if (right < left) {
            soluPrefix.append(")");
            dfs(soluPrefix, left, right + 1, n, res);
            soluPrefix.deleteCharAt(soluPrefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> res = generateParentheses.generateParenthesis(3);
        System.out.println(res);// [ ((())), (()()), (())(), ()(()), ()()() ]
    }
}
