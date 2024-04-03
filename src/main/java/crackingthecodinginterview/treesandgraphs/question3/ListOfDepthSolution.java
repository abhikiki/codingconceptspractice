package crackingthecodinginterview.treesandgraphs.question3;

import java.util.ArrayList;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

public class ListOfDepthSolution {
    // Time Complexity: O(N) N=total no. of nodes in the tree
    // Space Complexity: O(N).
    public ArrayList<ArrayList<Node>> buildDepthWiseList(Node root){
        ArrayList<ArrayList<Node>> results = new ArrayList<>();
        if(root == null)
            return results;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        ArrayList<Node> currList = new ArrayList<>();
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr != null){
                currList.add(curr);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            } else{
                if(!queue.isEmpty())
                    queue.add(null);
                results.add(currList);
                currList = new ArrayList<>();
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        ListOfDepthSolution sol = new ListOfDepthSolution();
        for(ArrayList<Node> depthList : sol.buildDepthWiseList(n1)){
            for(Node n : depthList)
                System.out.print(n.data + " ");
            System.out.println("");
        }
    }
}
