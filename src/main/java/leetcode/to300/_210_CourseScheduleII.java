package leetcode.to300;

import java.util.*;


public class _210_CourseScheduleII {

    public int[] findres(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }

    //Provide a second solution (Preferred).
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if(!outMap.containsKey(prerequisites[i][1])){
                outMap.put(prerequisites[i][1], new ArrayList<>());
            }
            outMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            res[index++] = num;
            if(!outMap.containsKey(num)) continue;
            for (int i : outMap.get(num)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
