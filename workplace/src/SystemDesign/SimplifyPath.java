package SystemDesign;

import java.util.Stack;

public class SimplifyPath {
    public String simplify(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
            if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) {
                s.push(p[i]);
            } else if (!s.isEmpty() && p[i].equals("..")) {
                s.pop();
            }
        }


        if (s.isEmpty())
            return "/";

        while (!s.isEmpty()) {
            String top = s.pop();
            System.out.println(top);
            res.insert(0, top).insert(0, "/");
//            System.out.println(res);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String res = sp.simplify("/a/./b/../../c/");
        System.out.println(res);
    }
}
