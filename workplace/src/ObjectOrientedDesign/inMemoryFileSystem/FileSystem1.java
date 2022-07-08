package ObjectOrientedDesign.inMemoryFileSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileSystem1 {
    File root;

    static class File {
        boolean isFile;
        Map<String, File> children;
        String content;

        File() {
            isFile = false;
            children = new HashMap();
            content = "";
        }
    }

    public FileSystem1() {
        root = new File();
    }

    public List<String> ls(String path) {
        File curFile = root;
        List<String> res = new ArrayList<>();
        String[] dirs = path.split("/");
        String fileName = "";
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            curFile = curFile.children.get(dir);
            fileName = dir;
            System.out.println(fileName);
        }
        if (curFile.isFile) {
//            System.out.println(fileName);
            res.add(fileName);
            System.out.println("inside ls method: " + res);
        } else {
            for (String key : curFile.children.keySet()) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        File curFile = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curFile.children.containsKey(dir)) {
                File file = new File();
                curFile.children.put(dir, file);
            }
            curFile = curFile.children.get(dir);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File curFile = root;
        String[] dirs = filePath.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curFile.children.containsKey(dir)) {
                File file = new File();
                curFile.children.put(dir, file);
            }
            curFile = curFile.children.get(dir);
        }
        curFile.content += content;
//        System.out.println("curFile.content: " + curFile.content);
        curFile.isFile = true;
    }

    public String readContentFromFile(String filePath) {
        File curFile = root;
        String[] dirs = filePath.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curFile.children.containsKey(dir)) {
                File file = new File();
                curFile.children.put(dir, file);
            }
            curFile = curFile.children.get(dir);
        }
        return curFile.content;
    }

    public static void main(String[] args) {
        FileSystem1 fs1 = new FileSystem1();
        fs1.ls("/");                         // return []
        fs1.mkdir("/a/b/c");
        fs1.addContentToFile("/a/b/c/d", "hello");
        fs1.ls("/");                         // return ["a"]
        fs1.readContentFromFile("/a/b/c/d"); // return "hello"
        System.out.println();

        fs1.addContentToFile("/a/b/c/e", "world");
        fs1.addContentToFile("/a/b/c/f", "hi");
        fs1.addContentToFile("/a/b/c/g", "hey");
//        System.out.println(fs1.ls("/a/b/c"));

        String res = fs1.readContentFromFile("/a/b/c/d");
        System.out.println(res);
        res = fs1.readContentFromFile("/a/b/c/e");
        System.out.println(res);

        System.out.println();
        List<String> list  = fs1.ls("/a/b/c");
        System.out.println(list);

        System.out.println();
        fs1.mkdir("/a/b/c/folder1");
        fs1.mkdir("/a/b/c/folder2");
        fs1.mkdir("/a/b/c/folder3");
        fs1.mkdir("/a/b/c/folder4");
        list = fs1.ls("/a/b/c");
        System.out.println(list);

//        System.out.println();
//        System.out.println("=========================");
//        List<String> str = fs1.ls("/a/b/c/d");
//        System.out.println(str);

    }
}
