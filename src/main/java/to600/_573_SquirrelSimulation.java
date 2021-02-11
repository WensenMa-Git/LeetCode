package to600;


public class _573_SquirrelSimulation {


    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int total = 0;
        int dis = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            total += distance(nut, tree) * 2;
            dis = Math.max(dis, distance(nut, tree) - distance(nut, squirrel));
        }
        return total - dis;
    }

    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
