package to100;

import java.util.*;


public class _49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
