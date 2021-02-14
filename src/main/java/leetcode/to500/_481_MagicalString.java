package leetcode.to500;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class _481_MagicalString {


    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }

        Deque<Integer> deque = new LinkedList<>(Arrays.asList(2));
        int res = 1;
        int len = 2;
        int nextNum = 1;

        while (len < n) {
            int cur = deque.removeFirst();
            if (cur == 1) {
                res++;
            }
            len++;
            for (int i = 0; i < cur; i++) {
                deque.addLast(nextNum);
            }
            nextNum = nextNum ^ 3;
        }

        return res;
    }
}
