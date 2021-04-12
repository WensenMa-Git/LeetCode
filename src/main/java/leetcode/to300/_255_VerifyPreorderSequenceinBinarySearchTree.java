package leetcode.to300;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * Subject: Tree
 * #Medium #Attention
 */
public class _255_VerifyPreorderSequenceinBinarySearchTree {

    public static boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }

    //Provide a second solution (Preferred)
    int index = 0;
    public boolean verifyPreorder2(int[] preorder) {
        recurse(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return index == preorder.length;
    }

    public void recurse(int[] preorder, int lower, int upper){
        if(index >= preorder.length || preorder[index] < lower || preorder[index] > upper){return;}
        int val = preorder[index++];
        recurse(preorder, lower, val); // left
        recurse(preorder, val, upper); // right
    }
}
