package to200;


public class _158_ReadNCharactersGivenRead4II_Callmultipletimes {


    private final char[] temp = new char[4];
    private int count = 0;
    private int pointer = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            while (index < n && pointer < count) {
                buf[index++] = temp[pointer++];
            }
            if (pointer == count) pointer = 0;
        }
        return index;
    }

    //辅助函数，正常不是这么写
    public int read4(char[] temp) {
        char[] res = new char[10];
        char[] ret = new char[4];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            if (index < 4) {
                ret[index++] = temp[i];
            }
        }
        return index;
    }
}
