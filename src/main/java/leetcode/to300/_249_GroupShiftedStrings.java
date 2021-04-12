package leetcode.to300;

import java.util.*;


public class _249_GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);  // 不排序也行
            res.add(list);
        }
        return res;
    }

    //Provide a second solution. (Preferred)
    public List<List<String>> groupStrings2(String[] strings) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strings){
            char[] arr = new char[s.length()];
            for(int i = 0; i<arr.length; i++){
                arr[i] += (s.charAt(i) - s.charAt(0) + 26) % 26;
            }
            String temp = new String(arr);
            List<String> list = map.getOrDefault(temp,new ArrayList<>());
            if(list.size() == 0){
                list.add(s);
                map.put(temp,list);
            }else{
                list.add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    //Provide a third solution. (Preferred)
    public List<List<String>> groupStrings3(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String currStr: strings) {
            StringBuilder sbKey = new StringBuilder();
            for(int i=1; i<currStr.length(); i++) {
                int charDiff = currStr.charAt(i) - currStr.charAt(i-1);
                if(charDiff<0)
                    charDiff+= 26;
                sbKey.append(charDiff+",");

            }
            String key = sbKey.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(currStr);
        }
        List<List<String>> retList = new ArrayList();
        for(String key: map.keySet()) {
            List<String> currList = new ArrayList<>(map.get(key));
            retList.add(currList);
        }
        return retList;
    }
}
