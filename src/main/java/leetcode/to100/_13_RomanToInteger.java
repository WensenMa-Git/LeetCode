package leetcode.to100;


public class _13_RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
                res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                res += toNumber(s.charAt(i));
            }
        }
        return res;
    }

    public static int toNumber(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return res;
    }

    //Provide a second solution (Preferred).
    public int romanToInt2(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                sum -= nums[i];
            }else{
                sum += nums[i];
            }
        }
        return nums[nums.length-1] + sum;
    }
}
