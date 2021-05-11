package leetcode.to600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-square/
 * Subject: Math
 * #Medium #Google
 */
public class _593_ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3), distance(p1, p4),
                distance(p2, p3), distance(p2, p4), distance(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    //Provide a second solution.
    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> distances=new HashSet<>();
        distances.add(distance2(p1,p2));
        distances.add(distance2(p1,p3));
        distances.add(distance2(p1,p4));
        distances.add(distance2(p2,p3));
        distances.add(distance2(p2,p4));
        distances.add(distance2(p3,p4));
        if(distances.contains(0.0)){
            return false;
        }
        return distances.size()==2;
    }

    double distance2(int p1[],int p2[]){
        int x=(p2[0]-p1[0])*(p2[0]-p1[0]);
        int y=(p2[1]-p1[1])*(p2[1]-p1[1]);
        return Math.sqrt(x+y);
    }
}
