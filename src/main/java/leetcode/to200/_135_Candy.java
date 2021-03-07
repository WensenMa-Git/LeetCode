package leetcode.to200;

import java.util.Arrays;

//
public class _135_Candy {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
