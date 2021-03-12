package leetcode.to300;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * Subject: Topological Sort
 * #Medium
 */
public class _207_CourseSchedule {


    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return res == 0;
    }

    //Provide a second solution (Preferred)
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0 || prerequisites == null) return false;
        if (prerequisites.length == 0) return true;
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
        while (!q.isEmpty()) {
            int num = q.poll();
            numCourses--;
            if(!outMap.containsKey(num)) continue;
            for (int i : outMap.get(num)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return numCourses == 0;
    }
}
