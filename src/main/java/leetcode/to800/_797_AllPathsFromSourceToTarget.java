package leetcode.to800;

import java.util.ArrayList;
import java.util.List;

public class _797_AllPathsFromSourceToTarget {

    //Preferred.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(res, tempList, 0, graph.length - 1, graph);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int current, int target, int[][] graph)    {
        tempList.add(current);
        if (current == target) {
            res.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        for (int next : graph[current]) {
            if (tempList.contains(next)) continue;
            backtrack(res, tempList, next, target, graph);
        }
        tempList.remove(tempList.size() - 1);
    }

    //Provide a second solution.
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        scanPath(res, path, graph, 0);
        return res;
    }

    private void scanPath(List<List<Integer>> res, List<Integer> path, int[][] graph, int idx){
        if(idx==graph.length-1){
            path.add(idx);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int next : graph[idx]){
            path.add(idx);
            scanPath(res, path, graph, next);
            path.remove(path.size()-1);
        }

    }
}
