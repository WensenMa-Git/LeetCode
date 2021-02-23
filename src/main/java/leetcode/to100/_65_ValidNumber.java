package leetcode.to100;

/**
 * https://leetcode.com/problems/valid-number/
 * Subject: String
 * #Hard
 */
public class _65_ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }

    //Provide a second solution (Preferred)
    public boolean isNumber2(String s) {
        s = s.trim();
        int start = 0;
        int end = s.length();
        if(start < end && (s.charAt(start) == '+' || s.charAt(start) == '-')) start++;
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasEPreNum = false;
        boolean hasEBackNum = false;
        boolean hasNum = false;
        int eIndex = -2147483648;

        for(int i = start; i < end; i++){
            char cur = s.charAt(i);
            if(cur == '.'){
                if(hasDot || hasE){ //"3." is a number. "3.e7" is a number
                    return false;
                }else{
                    hasDot = true;
                    continue;
                }
            }
            if(cur == 'e' || cur == 'E'){
                if(hasE){
                    return false;
                }else{
                    eIndex = i;
                    hasE = true;
                    continue;
                }
            }
            if((cur == '-' || cur == '+') && i == eIndex + 1) continue;
            if(cur <= '9' && cur >= '0'){
                if(hasE){
                    hasEBackNum = true;
                }else{
                    hasEPreNum = true;
                }
                hasNum = true;
                continue;
            }else{
                return false;
            }
        }
        if(!hasNum) {
            return false;
        }
        if(hasE) return hasEPreNum && hasEBackNum;
        return true;

    }
}
