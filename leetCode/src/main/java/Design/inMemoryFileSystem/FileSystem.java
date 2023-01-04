package Design.inMemoryFileSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileSystem {
    File root;

    static class File {
        boolean isFile;
        Map<String, File> children;
        String content;
        File () {
            isFile = false;
            children = new HashMap();
            content = "";
        }
    }

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File curFile = root;
        List<String> res = new ArrayList<>();
        String [] dirs = path.split("/");
        String fileName = "";
        System.out.println("==========================");
        System.out.println("ls :");
        for (String dir : dirs) {
            System.out.println("This is dir's name: " + dir);
            if (dir.length() == 0) {
                continue;
            }
            if (!curFile.children.containsKey(dir)) {
                return res;
            }
            curFile = curFile.children.get(dir);
            fileName = dir;
        }
        if (curFile.isFile) {
            res.add(fileName);
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
        String [] dirs = path.split("/");
        System.out.println("==========================");
        System.out.println("Make dir:");
        System.out.println(Arrays.toString(dirs));
        for (String dir : dirs) {
            System.out.println("This is dir's name: " + dir);
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

    public void addContentToFile(String filePath,
                                 String content) {
        File curFile = root;
        String [] dirs = filePath.split("/");
        System.out.println("==========================");
        System.out.println("add content to file.");
        for (String dir : dirs) {
            System.out.println("This is dir's name: " + dir);
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
        curFile.isFile = true;
    }

    public String readContentFromFile(String filePath){
        File curFile = root;
        String [] dirs = filePath.split("/");
        System.out.println("==========================");
        System.out.println("read content from file.");
        for (String dir : dirs) {
            System.out.println("This is dir's name: " + dir);
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
        FileSystem fileSystem = new FileSystem();
        fileSystem.ls("/");                         // return []
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        fileSystem.ls("/");                         // return ["a"]
        fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
    }
}
