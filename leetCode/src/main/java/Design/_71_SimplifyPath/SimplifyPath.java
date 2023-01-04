package Design._71_SimplifyPath;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public String simplify(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] dirs = path.split("/");
        System.out.println(Arrays.toString(dirs));
        // Note: first String is ""
        // [, a, ., b, .., .., c]

        for (int i = 0; i < dirs.length; i++) {
            System.out.println(dirs[i]);

            if (dirs[i].equals(".")) {
                continue;
            }
            if (!dirs[i].equals("") && !dirs[i].equals("..")) {
                stack.push(dirs[i]);
            } else if (!stack.isEmpty() && dirs[i].equals("..")) {
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            return "/";
        }

        while (!stack.isEmpty()) {
            String top = stack.pop();
            System.out.println(top);
            res.insert(0, top).insert(0, "/");
//            System.out.println(res);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
//        String res = sp.simplify("a/./b/../../c/");
        String res = sp.simplify("/a/./b/../../c/");
        System.out.println(res); //  /c
    }
}
