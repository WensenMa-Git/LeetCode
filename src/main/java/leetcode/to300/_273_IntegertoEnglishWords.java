package leetcode.to300;


public class _273_IntegertoEnglishWords {

    String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }

    public String helper(int num) {
        if (num == 0) return "";
        if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    //Provide a second solution. (Preferred)
    private String[] THOUSANDS = {" Billion", " Million", " Thousand", " Hundred"};
    private String[] LESS20 = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    private String[] TENS = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    private int[] radix = {1000000000, 1000000, 1000, 100};

    public String numberToWords2(int num) {
        String s = format(num);
        return s.trim();
    }

    public String format(int num) {
        if (num == 0) return "Zero";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            if (num >= radix[i]) {
                sb.append(format(num / radix[i]));
                sb.append(THOUSANDS[i]);
                num %= radix[i];
            }
        }
        if (num >= 20) {
            sb.append(TENS[num / 10]);
            num %= 10;
        }
        if (num > 0) {
            sb.append(LESS20[num]);
        }
        return sb.toString();
    }

    //Provide a third implementation.
    public String format2(int num) {
        if (num == 0) return "Zero";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            if (num >= radix[i]) {
                sb.append(format(num / radix[i]));
                sb.append(THOUSANDS[i]);
                num %= radix[i];
            }
        }
        if (num >= 20) {
            sb.append(TENS[num / 10]);
            num %= 10;
        }
        if (num > 0) {
            sb.append(LESS20[num]);
        }



        // 20-90
        if (num >= 20) {
            switch (num / 10) {
                case 2:
                    sb.append(" Twenty");
                    break;
                case 3:
                    sb.append(" Thirty");
                    break;
                case 4:
                    sb.append(" Forty");
                    break;
                case 5:
                    sb.append(" Fifty");
                    break;
                case 6:
                    sb.append(" Sixty");
                    break;
                case 7:
                    sb.append(" Seventy");
                    break;
                case 8:
                    sb.append(" Eighty");
                    break;
                case 9:
                    sb.append(" Ninety");
                    break;
            }
            num %= 10;
        }
        // 1-19
        if (num > 0) {
            switch (num) {
                case 1:
                    sb.append(" One");
                    break;
                case 2:
                    sb.append(" Two");
                    break;
                case 3:
                    sb.append(" Three");
                    break;
                case 4:
                    sb.append(" Four");
                    break;
                case 5:
                    sb.append(" Five");
                    break;
                case 6:
                    sb.append(" Six");
                    break;
                case 7:
                    sb.append(" Seven");
                    break;
                case 8:
                    sb.append(" Eight");
                    break;
                case 9:
                    sb.append(" Nine");
                    break;
                case 10:
                    sb.append(" Ten");
                    break;
                case 11:
                    sb.append(" Eleven");
                    break;
                case 12:
                    sb.append(" Twelve");
                    break;
                case 13:
                    sb.append(" Thirteen");
                    break;
                case 14:
                    sb.append(" Fourteen");
                    break;
                case 15:
                    sb.append(" Fifteen");
                    break;
                case 16:
                    sb.append(" Sixteen");
                    break;
                case 17:
                    sb.append(" Seventeen");
                    break;
                case 18:
                    sb.append(" Eighteen");
                    break;
                case 19:
                    sb.append(" Nineteen");
                    break;
            }
        }
        return sb.toString();
    }
}
