package to500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class _500_KeyboardRow {


    public String[] findWords(String[] words) {

        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> keyboard = new HashMap<>();

        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                keyboard.put(c, i);
            }
        }

        List<String> res = new ArrayList<>();

        for (String word : words) {
            char[] letters = word.toLowerCase().toCharArray();

            boolean sameRow = true;
            int index = keyboard.get(letters[0]);
            for (char c : letters) {
                if (index != keyboard.get(c)) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow) {
                res.add(word);
            }
        }

        return res.stream().toArray(String[]::new);
    }
}
