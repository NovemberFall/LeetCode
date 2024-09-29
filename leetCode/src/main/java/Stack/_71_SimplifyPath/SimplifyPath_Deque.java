package Stack._71_SimplifyPath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SimplifyPath_Deque {
        public String simplify(String path) {
        Deque<String> deque = new ArrayDeque<>();
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
                deque.addLast(dirs[i]);
            } else if (!deque.isEmpty() && dirs[i].equals("..")) {
                deque.pollLast();
            }
        }

        if (deque.isEmpty()){
            return "/";
        }

        while (!deque.isEmpty()) {
            String top = deque.pollFirst();
            System.out.println(top);
            res.append("/").append(top);
//            System.out.println(res);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SimplifyPath_Deque sp = new SimplifyPath_Deque();
//        String res = sp.simplify("a/./b/../../c/");
        String res = sp.simplify("/a/./b/../../c/");
        System.out.println(res); //  /c

        res = sp.simplify("/a/b/c/d/../e");
        System.out.println(res); //   /a/b/c/e
    }
}
