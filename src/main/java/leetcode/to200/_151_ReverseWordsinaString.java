package leetcode.to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Subject: Two Pointer
 * #Medium
 */
public class _151_ReverseWordsinaString {

    //time : O(n), space : O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

    // time : O(n) space : O(n)
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
        reverseWord(ch, s.length());
        return cleanSpaces(ch, s.length());
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
    }

    private void reverseWord(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < j || i < len && ch[i] == ' ') i++;
            while (j < i || j < len && ch[j] != ' ') j++;
            reverse(ch, i, j - 1);
        }
    }

    private String cleanSpaces(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && ch[j] == ' ') j++;
            while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
            while (j < len && ch[j] == ' ') j++;
            if (j < len) ch[i++] = ' ';
        }
        return String.valueOf(ch).substring(0, i);
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] arr = new char[s.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] += (s.charAt(i) - s.charAt(0) + 26) % 26;
            }
            String temp = new String(arr);
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            if (list.size() == 0) {
                list.add(s);
                map.put(temp, list);
            } else {
                list.add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupStrings2(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> retList = new ArrayList<>();
        for (String str : strings) {
            char[] arr = new char[str.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] += (str.charAt(i) - str.charAt(0) + 26) % 26;
            }
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            if (list.isEmpty()) {
                map.put(key, list);
                retList.add(list);
            }
            list.add(str);
        }
        return retList;
    }

    //Provide a third solution (Preferred)
    public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        for(int R = s.length(), L = s.length() - 1; L >= 0; L--){
            if(s.charAt(L) == ' '){
                R = L;
                continue;
            }
            if(L == 0 || s.charAt(L - 1) == ' '){
                if(sb.length() > 0){
                    sb.append(' ');
                }
                sb.append(s.substring(L, R));

            }
        }
        return sb.toString();
    }
}
