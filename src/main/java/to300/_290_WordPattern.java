package to300;

import java.util.HashMap;


public class _290_WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c).equals(arr[i])) continue;
                else return false;
            } else {
                if (!map.containsValue(arr[i])) {
                    map.put(c, arr[i]);
                } else return false;
            }
        }

        return true;
    }
}
