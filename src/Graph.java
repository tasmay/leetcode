/*
* Basic Graph Implementation
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public static void iterativeDFS(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.val);
            for(Node n : current.neighbors) {
                stack.push(n);
            }
        }
    }

    public static void recDFS(Node node) {
        System.out.println(node.val);
        for(Node n : node.neighbors) {
            recDFS(n);
        }
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.val);
            for(Node n : current.neighbors) {
                queue.add(n);
            }
        }
    }

//    public static boolean hasPath(Node src, Node dst) {
//        if(src == dst) return true;
//        return false;
//    }

    public static void main(String[] args) {
        // directed graph
        Node node1 = new Node(3);
        Node node2 = new Node(9);
        Node node3 = new Node(20);
        Node node4 = new Node(15);
        Node node5 = new Node(17);
        Node node6 = new Node(2);
        node1.addNeighbor(node2);
        node1.addNeighbor(node3);
        node2.addNeighbor(node4);
        node3.addNeighbor(node5);
        node4.addNeighbor(node6);

        iterativeDFS(node1);
        recDFS(node1);
        bfs(node1);
    }
}
