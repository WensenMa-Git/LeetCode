package to400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class _399_EvaluateDivision {


    HashMap<String, List<GraphNode>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1 / values[i]));
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;

        if (start.equals(end)) return value;
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String den;
        double val;

        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}

