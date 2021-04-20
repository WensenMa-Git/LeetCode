package leetcode.to300;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/word-pattern/
 * Subject: HashMap
 * #Easy
 */
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

    //Provide a second solution. (Preferred)
    public boolean wordPattern2(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        String[] s = str.split(" ");
        if(s.length != pattern.length()) return false;
        int i = 0;
        while(i < pattern.length()){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(s[i])){
                    return false;
                }
            }else {
                if(map.containsValue(s[i])) return false;
                map.put(pattern.charAt(i),s[i]);
            }
            i++;
        }
        return true;
    }
}
