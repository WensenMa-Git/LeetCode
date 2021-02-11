package to600;

import dependency.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class _501_FindModeinBinarySearchTree {


    int count = 1;
    int max = 0;
    Integer pre = null;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        if (pre != null) {
            if (root.val == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root.val;
        helper(root.right, list);
    }

}
