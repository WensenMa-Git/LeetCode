package leetcode.toLast;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * Subject: Stack
 * #Medium
 * Similar questions: https://leetcode.com/discuss/interview-question/124551/balance-parenthesis-in-an-alphanumeric-string
 */
public class _921_MinimumAddToMakeParenthesesValid {

    //Preferred Solution.
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
            } else{
                if(stack.isEmpty()) result++;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()){
            result+=stack.size();
        }
        return result;
    }

}
