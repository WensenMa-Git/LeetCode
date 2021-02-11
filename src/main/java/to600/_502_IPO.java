package to600;

import java.util.PriorityQueue;


public class _502_IPO {


    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            cap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!cap.isEmpty() && cap.peek()[0] <= W) {
                pro.add(cap.poll());
            }
            if (pro.isEmpty()) {
                break;
            }
            W += pro.poll()[1];
        }
        return W;
    }
}
