package leetcode.to700;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * Subject: Tree
 * #Easy #Attention
 */
public class _606_ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strUtil(t, sb);
        return sb.toString();
    }

    private void tree2strUtil(TreeNode t, StringBuilder sb){
        if(t == null) return;
        sb.append(t.val);
        if(t.left != null) {
            sb.append('(');
            tree2strUtil(t.left, sb);
            sb.append(')');
        }
        if(t.left == null && t.right != null){
            sb.append("()");
        }
        if(t.right != null) {
            sb.append('(');
            tree2strUtil(t.right, sb);
            sb.append(')');
        }
    }

    //Solution 2
    public String tree2str2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        construct(t, sb);
        return sb.toString();
    }

    private void construct(TreeNode t, StringBuilder sb) {
        if(t == null) {
            sb.append("");
            return;
        }
        sb.append(t.val);
        if(t.left == null && t.right == null) {
            return;
        }
        if(t.left != null) {
            sb.append("(");
            construct(t.left, sb);
            sb.append(")");
        } else {
            sb.append("()");
        }
        if(t.right != null) {
            sb.append("(");
            construct(t.right, sb);
            sb.append(")");
        }
    }
}
