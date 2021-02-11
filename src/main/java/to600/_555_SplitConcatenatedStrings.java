package to600;


public class _555_SplitConcatenatedStrings {


    public static String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[]{strs[i], rev}) {
                for (int k = 0; k < st.length(); k++) {
                    StringBuilder temp = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++) {
                        temp.append(strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        temp.append(strs[j]);
                    }
                    temp.append(st, 0, k);
                    if (temp.toString().compareTo(res) > 0) {
                        res = temp.toString();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        splitLoopedString(new String[]{"abc", "xyz"});
    }
}
