package to400;

import java.util.*;


public class _332_ReconstructItinerary {


    HashMap<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        helper("JFK");
        return res;
    }

    private void helper(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll());
        }
        res.add(0, airport);
    }

    public List<String> findItinerary2(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        }

        List<String> res = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }

        return res;
    }
}
