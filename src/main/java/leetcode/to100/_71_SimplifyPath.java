package leetcode.to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 * Subject: String
 * #Medium
 */
public class _71_SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public String simplifyPath2(String path) {
        String[] parts = path.split("/");
        List<String> list = new ArrayList<>();
        for(String part : parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(list.size() > 0){
                    list.remove(list.size() - 1);
                }
            }else{
                list.add(part);
            }
        }
        if(list.size() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for(String part : list){
            sb.append("/");
            sb.append(part);
        }
        return sb.toString();
    }

}
