package leetcode.to700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/
 * Subject: DFS
 * #Easy #Google
 */
public class _690_EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int[] res = new int[1];
        dfs(res, map, id);
        return res[0];
    }

    private void dfs(int[] res, Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        res[0] += e.importance;
        for (Integer nextId : e.subordinates) {
            dfs(res, map, nextId);
        }
    }

    class Employee{
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
