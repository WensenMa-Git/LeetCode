package to100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class _18_4Sum {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else if (map.containsValue(cur)) {
                if (stack.isEmpty() || map.get(stack.pop()) != cur) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}