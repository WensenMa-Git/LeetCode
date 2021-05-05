package leetcode.to700;

import leetcode.dependency.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * Subject: Tree
 * #Medium
 */
public class _652_FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList();
        Map<String, Integer> map = new HashMap();
        if (root == null) return res;
        dfs(root, res, map);
        return res;
    }

    private String dfs(TreeNode node, List<TreeNode> res, Map<String, Integer> map) {
        if (node == null) return "#";
        String left = dfs(node.left, res, map);
        String right = dfs(node.right, res, map);
        String root = node.val + left + right;
        if (map.containsKey(root) && map.get(root) == 1) res.add(node);
        map.put(root, map.getOrDefault(root, 0) + 1);

        return root;
    }
}
