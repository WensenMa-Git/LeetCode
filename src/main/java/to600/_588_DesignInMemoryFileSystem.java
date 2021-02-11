package to600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class _588_DesignInMemoryFileSystem {

    Node root;


    public _588_DesignInMemoryFileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if (node.isFile) {
            res.add(node.name);
        } else {
            for (String child : node.children.keySet()) {
                res.add(child);
            }
        }
        Collections.sort(res); // 删除 nlogn
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
        String[] path = filePath.split("/");
        Node cur = root;
        for (int i = 1; i < path.length; i++) {
            if (!cur.children.containsKey(path[i])) {
                Node node = new Node(path[i]);
                cur.children.put(path[i], node);
            }
            cur = cur.children.get(path[i]);
        }
        return cur;
    }

    class Node {
        String name;
        boolean isFile;
        StringBuilder content;
        HashMap<String, Node> children;  // TreeMap

        public Node(String name) {
            this.name = name;
            isFile = false;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }
}
