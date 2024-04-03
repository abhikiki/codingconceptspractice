package crackingthecodinginterview.treesandgraphs.question4;

import java.util.HashMap;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
public class BalancedTreeCheckerSolution1 {

    //memonization
    private HashMap<Node, Integer> heightMap = new HashMap<>();

    // Time Complexity: O(N)
    // Space Complexity: O(N + N) = O(N)
    public boolean isBalancedTree(Node root){
        if(root == null){
            return true;
        }
        int leftHeight = heightMap.containsKey(root.left) ? heightMap.get(root.left) : heightOfTree(root.left);
        heightMap.putIfAbsent(root.left, leftHeight);
        int rightHeight = heightMap.containsKey(root.right) ? heightMap.get(root.right) : heightOfTree(root.right);
        heightMap.putIfAbsent(root.right, rightHeight);

        int diff = Math.abs(rightHeight - leftHeight);
        if(diff > 1)
            return false;
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    private int heightOfTree(Node root){
        if(root == null)
            return -1;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);
        root.left.left = new Node(30);
        BalancedTreeCheckerSolution1 sol = new BalancedTreeCheckerSolution1();

        if (sol.isBalancedTree(root))
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");
    }
}
