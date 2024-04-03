package crackingthecodinginterview.treesandgraphs.question4;

import java.util.HashMap;

public class BalancedTreeCheckerSolution2 {


    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isBalancedTree(Node root){
        if(root == null)
            return true;
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node root){
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(Math.abs(rightHeight - leftHeight) > 1)
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);
        root.left.left = new Node(30);
        BalancedTreeCheckerSolution2 sol = new BalancedTreeCheckerSolution2();

        if (sol.isBalancedTree(root))
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");
    }
}
