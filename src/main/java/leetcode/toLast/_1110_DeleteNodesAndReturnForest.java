package leetcode.toLast;

import leetcode.dependency.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * Subject: Tree
 * #Medium #Attention #Google
 */
public class _1110_DeleteNodesAndReturnForest {

    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] delete = new boolean[1001];
        for (int n : to_delete)
            delete[n] = true;
        dfs(root, delete, true);
        return res;
    }

    boolean dfs(TreeNode root, boolean[] delete, boolean noParent) {
        if (root == null) return true;
        if (!delete[root.val] && noParent) res.add(root);
        if (dfs(root.left, delete, delete[root.val]))
            root.left = null;
        if (dfs(root.right, delete, delete[root.val]))
            root.right = null;
        return delete[root.val];
    }

}
