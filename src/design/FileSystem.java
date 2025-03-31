package design;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    class Trie {
        String name;
        int val = -1;
        Map<String, Trie> map = new HashMap<>();

        Trie(String name) {
            this.name = name;
        }
    }

    Trie root;

    public FileSystem() {
        root = new Trie("");
    }

    public boolean createPath(String path, int value) {
        String[] components = path.split("/");
        Trie curr = root;
        for (int i = 1; i < components.length; i++) {
            String currComponent = components[i];
            if (!curr.map.containsKey(currComponent)) {
                if (i == (components.length - 1)) {
                    curr.map.put(currComponent, new Trie(currComponent));
                } else {
                    return false;
                }
            }
            curr = curr.map.get(currComponent);
        }
        if (curr.val != -1) {
            return false;
        }
        curr.val = value;
        return true;

    }

    public int get(String path) {
        String[] components = path.split("/");
        Trie curr = root;
        for (int i = 1; i < components.length; i++) {
            String currComponent = components[i];
            if (!curr.map.containsKey(currComponent)) {
                return -1;
            }
            curr = curr.map.get(currComponent);
        }
        return curr.val;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.createPath("/a", 1));
        System.out.println(fs.get("/a"));
        System.out.println(fs.createPath("/a/b", 2));
        System.out.println(fs.get("/a/b"));
        System.out.println(fs.createPath("/c/b", 3));
        System.out.println(fs.get("/c/b"));
    }
}
