package lintcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/715406/Facebook-merge-graph-nodes
 * The idea is to merge if the node has 1 neighbor and that neighbor indegree is 1
 */
public class MergeGraphNodes {

    static class Node {
        public String name;
        public List<Node> neighbors;

        public Node(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }
    }

    public void merge(List<Node> nodes) {
        HashMap<Node, List<Node>> indegree = new HashMap<>();
        for (Node node : nodes) {
            indegree.putIfAbsent(node, new ArrayList<>());
            //indegree
            for (Node neighbor : node.neighbors) {
                indegree.putIfAbsent(neighbor, new ArrayList<>());
                indegree.get(neighbor).add(node);
            }
        }

        Set<Node> removal = new HashSet<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node.neighbors.size() == 1 && indegree.get(node.neighbors.get(0)).size() == 1) {
                //merge node,
                Node secondNode = node.neighbors.get(0);
                node.name += secondNode.name;

                removal.add(secondNode);
                node.neighbors.remove(secondNode);
                Iterator<Node> iterator = secondNode.neighbors.iterator();
                while(iterator.hasNext()) {
                    Node next = iterator.next();
                    node.neighbors.add(next);
                    indegree.get(next).add(node);
                    iterator.remove();
                    indegree.get(next).remove(secondNode);
                }
                i--;
            }
        }
        nodes.removeAll(removal);
    }


    public static void main(String[] args) {
        Node nodeF = new Node("F");
        Node nodeD = new Node("D");
        Node nodeC = new Node("C");
        nodeC.neighbors.add(nodeD);
        nodeC.neighbors.add(nodeF);
        Node nodeB = new Node("B");
        nodeB.neighbors.add(nodeC);
        Node nodeA = new Node("Z");
        nodeA.neighbors.add(nodeB);
        Node nodeE = new Node("E");
        nodeE.neighbors.add(nodeB);

        List<Node> input = new ArrayList<>();
        input.add(nodeF);
        input.add(nodeC);
        input.add(nodeA);
        input.add(nodeB);
        input.add(nodeD);
        input.add(nodeE);
        new MergeGraphNodes().merge(input);
    }




}
