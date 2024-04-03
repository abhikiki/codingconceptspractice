package crackingthecodinginterview.treesandgraphs.question1;

import java.util.LinkedList;

public class RouteBetweenNodesSolution2 {
    // BFS approach - is a non-recursive approach
    // Time Complexity: O(N) total no. of nodes in the graph
    // Space complexity: O(N)
    public boolean routeExistsBfs(Node start, Node end){
        if(start == null || end == null)
            return false;

        LinkedList<Node> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(start);
        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            if(!node.isVisited()){
                if(node == end){
                    return true;
                } else{
                    node.setVisited(true); // prevent cycle
                    for(Node neighbour : node.getNeighbours()){
                        nodeQueue.addLast(neighbour);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(50);
        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n1.addNeighbor(n4);
        n3.addNeighbor(n5);
        n3.addNeighbor(n6);
        n4.addNeighbor(n6);

        RouteBetweenNodesSolution2 sol = new RouteBetweenNodesSolution2();
        System.out.println(sol.routeExistsBfs(n1, n6));
    }
}
