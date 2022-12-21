/*
* https://leetcode.com/problems/clone-graph/
* */

import java.util.HashMap;

public class CloneGraph {

    public static HashMap<Integer, Node> mapping = new HashMap<Integer, Node>();

    public static Node cloneGraph(Node node) {
        if(node == null) return null;

        if(mapping.containsKey(node.val)) {
            return mapping.get(node.val);
        }

        Node copyNode = new Node(node.val);
        mapping.put(node.val, copyNode);
        for(Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }
        return copyNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.addNeighbor(node2);
        node1.addNeighbor(node4);
        node2.addNeighbor(node1);
        node2.addNeighbor(node3);
        node3.addNeighbor(node2);
        node3.addNeighbor(node4);
        node4.addNeighbor(node1);
        node4.addNeighbor(node3);
        Node copy = cloneGraph(node1);
    }
}
