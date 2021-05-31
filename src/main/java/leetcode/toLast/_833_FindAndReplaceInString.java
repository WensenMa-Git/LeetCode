package leetcode.toLast;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 * Subject: String
 * #Medium #Google
 */
public class _833_FindAndReplaceInString {

    //Preferred solution
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }

        for (int i = 0; i < S.length(); i++) {
            Integer index = map.get(i);
            if (index != null && S.indexOf(sources[index], i) == i) {
                sb.append(targets[index]);
                i += sources[index].length() - 1;
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    //Provide a second solution.
    public String findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder result=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i =0;i<indexes.length;i++){
            map.put(indexes[i],i);
        }
        int i =0;
        while(i<S.length()){
            Integer actualIndex=map.get(i);
            if(actualIndex!=null && S.indexOf(sources[actualIndex],i)==i){
                result.append(targets[actualIndex]);
                i=i+sources[actualIndex].length();
            }else{
                result.append(S.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

}
