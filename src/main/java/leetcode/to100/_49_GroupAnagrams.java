package leetcode.to100;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * Subject: Map
 * #Medium
 */
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
                    s += String.valueOf(count[i]) + (char) (i + 'a');
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

    //Provide a second solution (Preferred)
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String encoded = encode(str);
            if (map.containsKey(encoded))
                map.get(encoded).add(str);
            else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(encoded, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            ret.add(entry.getValue());
        return ret;
    }
    private String encode(String str) {
        int[] freq = new int[26];
        String spliter = "-";
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++)
            sb.append(freq[i]).append(spliter);
        return sb.toString();
    }

    //Provide a third solution.
    public List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

}