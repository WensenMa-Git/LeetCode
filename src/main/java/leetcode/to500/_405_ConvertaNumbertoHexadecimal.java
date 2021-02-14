package leetcode.to500;


public class _405_ConvertaNumbertoHexadecimal {


    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(map[num & 15]);
            num = num >>> 4;
        }
        return res.reverse().toString();
    }
}
