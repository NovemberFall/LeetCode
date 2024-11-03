package _OA_OnSite_tags.TikTok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _588_Design_In_MemoryFileSystem {

    class Node{
        String name;
        boolean isFile;
        StringBuilder content;
        Map<String, Node> children;

        public Node(String name) {
            this.name = name;
            isFile = false;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }

    Node root;

    public _588_Design_In_MemoryFileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if (node.isFile) {
            res.add(node.name);
        } else {
            for (String key : node.children.keySet()) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }

    private Node traverse(String filePath) {
        String[] paths = filePath.split("/");
        Node cur = root;
        for (int i = 1; i < paths.length; i++) {
            if (!cur.children.containsKey(paths[i])) {
                Node node = new Node(paths[i]);
                cur.children.put(paths[i], node);
            }
            cur = cur.children.get(paths[i]);
        }
        return cur;
    }

    public static void main(String[] args) {
        _588_Design_In_MemoryFileSystem designInMemoryFileSystem = new _588_Design_In_MemoryFileSystem();
        System.out.println(designInMemoryFileSystem.ls("/"));
        designInMemoryFileSystem.mkdir("/a/b/c");
        designInMemoryFileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(designInMemoryFileSystem.ls("/"));
        System.out.println(designInMemoryFileSystem.readContentFromFile("/a/b/c/d"));
    }
}
