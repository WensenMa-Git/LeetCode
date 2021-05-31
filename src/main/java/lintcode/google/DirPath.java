package lintcode.google;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Input is a list of String:
 * [
 * "/dir1/dir11/abc.txt",
 * "/dir1/dir12/picture.jpeg",
 * "/dir1/dir12/file1.txt",
 * "/dir3/file2.gif",
 * "file3.html",
 * "/dir1/dir12/dir121"
 * ]
 *
 * Expected output:
 * -dir1
 * --dir11
 * ---abc.txt
 * --dir12
 * ---picture.jpeg
 * ---dir121
 * ---file1.txt
 * -dir3
 * --file2.gif
 * -file3.html
 */
public class DirPath {

    static class Node {
        String name;
        boolean isFile;
        Map<String, Node> map = new LinkedHashMap<>();

        public Node(String dir) {
            this.name = dir;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", isFile=" + isFile +
                    ", map=" + map +
                    '}';
        }
    }

    private final Node root;

    public DirPath() {
        root = new Node(null);
    }

    public void insert(String dirPath) {
        Node node = root;
        String[] dirs = dirPath.split("/");
        for (String dir : dirs) {
            if (dir.equals("")) continue;
            if (node.map.containsKey(dir)) {
                node = node.map.get(dir);
            } else {
                Node next = new Node(dir);
                if (dir.contains(".")) {
                    next.isFile = true;
                } else {
                    next.isFile = false;
                }
                node.map.put(dir, next);
                node = next;

            }
        }
    }

    private void dfs(Node root, int level) {
        if (level > 0) {
            String prefix = "";
            for (int i = 0; i < level; i++) {
                prefix += "-";
            }
            System.out.println(prefix + root.name);
        }

        for (Node next : root.map.values()) {
            dfs(next, level + 1);
        }
    }

    public static void main(String[] args) {
        DirPath dirPath = new DirPath();
        dirPath.insert("/dir1/dir11/abc.txt");
        dirPath.insert("/dir1/dir12/picture.jpeg");
        dirPath.insert("/dir1/dir12/file1.txt");
        dirPath.insert("/dir3/file2.gif");
        dirPath.insert("file3.html");
        dirPath.insert("/dir1/dir12/dir121");
        dirPath.dfs(dirPath.root, 0);
    }

}
