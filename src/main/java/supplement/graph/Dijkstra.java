package supplement.graph;

import java.util.*;

/**
 * Reference problem: https://leetcode.com/discuss/interview-question/378040/yelp-oa-2019-recommend-businesses
 */
public class Dijkstra {

    static class Business {
        String name;
        Map<Business, Integer> nearbyBusinesses;
        public Business(String name, Map<Business, Integer> nearbyBusinesses) {
            this.name = name;
            this.nearbyBusinesses = nearbyBusinesses;
        }
        public String getName() {
            return this.name;
        }
        public Map<Business, Integer> getNearbyBusinesses() {
            return this.nearbyBusinesses;
        }
    }

    //For the graph which has circle, print all node shortest distance from the rootNode.
    public void dijkstra(Business rootBusiness) {
        Set<Business> out = new HashSet<>();
        PriorityQueue<Pair<Business, Integer>> pq = new PriorityQueue<>(((o1, o2) -> {return o1.getValue() - o2.getValue();}));
        Map<Business, Pair<Business, Integer>> map = new HashMap<>();
        Pair<Business, Integer> originalPair = new Pair<>(rootBusiness, 0);
        pq.offer(originalPair);
        map.put(originalPair.key, originalPair);
        while(!pq.isEmpty()) {
            Pair<Business, Integer> cur = pq.poll();
            System.out.println(cur.getKey().name + " " + cur.getValue());
            out.add(cur.getKey());
            for (Map.Entry<Business, Integer> next : cur.getKey().getNearbyBusinesses().entrySet()) {
                if (out.contains(next.getKey())) continue;
                if (map.containsKey(next.getKey())) {
                    Pair<Business, Integer> pair = map.get(next.getKey());
                    if (pair.getValue() > cur.getValue() + next.getValue()) {
                        pq.remove(pair);
                        pair.setValue(cur.getValue() + next.getValue());
                        pq.offer(pair);
                    }
                } else {
                    Pair<Business, Integer> pair = new Pair<>(next.getKey(), cur.getValue() + next.getValue());
                    pq.offer(pair);
                    map.put(pair.key, pair);
                }
            }
        }
        System.out.println(map);
    }

    public List<String> findReachableBusinesses0(Business startingBusiness, int distance) {
        List<String> res = new ArrayList<>();
        dfs0(res, startingBusiness, distance);
        res.remove(startingBusiness.name);
        return res;
    }

    private void dfs0(List<String> res, Business business, int distance){
        if (distance < 0) {
            return;
        }
        res.add(business.getName());
        for (Map.Entry<Business, Integer> next : business.getNearbyBusinesses().entrySet()) {
            dfs0(res, next.getKey(), distance - next.getValue());
        }
    }

    static class Pair<K, V> {
        K key;
        V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Business d = new Business("D", new HashMap<>());
        Map<Business, Integer> bNearBy = new HashMap<>();
        bNearBy.put(d, 5);
        Business b = new Business("B", bNearBy);
        Business c = new Business("C", new HashMap<>());
        Map<Business, Integer> cNearBy = c.getNearbyBusinesses();
        cNearBy.put(b, 1);
        Map<Business, Integer> aNearBy = new HashMap<>();
        aNearBy.put(b, 4);
        aNearBy.put(c, 2);
        Business a = new Business("A", aNearBy);
        new Dijkstra().dijkstra(a);
        System.out.println();
    }
}
