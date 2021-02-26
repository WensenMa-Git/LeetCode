package leetcode.to100;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Subject: Dynamic Programming
 * #Medium #Attension
 */
public class _96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }

    //Provide a second solution (Preferred)
    //https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
