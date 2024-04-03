package crackingthecodinginterview.treesandgraphs.question1;

import java.util.HashSet;

class Node{
    private int data;
    private boolean isVisited;
    private HashSet<Node> neighbours = new HashSet<>();

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public HashSet<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(HashSet<Node> neighbours) {
        this.neighbours = neighbours;
    }

    private Node(){}

    public Node(int data){
        this.data = data;
    }

    public void addNeighbor(Node neighbor){
        neighbours.add(neighbor);
    }
}
public class RouteBetweenNodesSolution1 {
    // DFS approach - recursive approach
    // Time Complexity: O(N) total no. of nodes in the graph
    // Space complexity: O(N)
    public boolean routeExistsDfs(Node start, Node end){
        if(start == null || end == null)
            return false;
        if(start == end)
            return true;
        start.setVisited(true); // prevent cycle
        for(Node neighbour : start.getNeighbours()){
            if(!neighbour.isVisited() && routeExistsDfs(neighbour, end)){
                return true;
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

        RouteBetweenNodesSolution1 sol = new RouteBetweenNodesSolution1();
        System.out.println(sol.routeExistsDfs(n1, n6)); // true

    }

}
