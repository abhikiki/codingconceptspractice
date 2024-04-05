package crackingthecodinginterview.treesandgraphs.question10;

import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

public class CheckSubtreeSolution1 {

    //Time Complexity: O(N +kM) where
    // N=total  nodes in t1
    // k = no. of occurrences of t2 in t1
    //M = total nodes in t2
    public boolean containsTree(Node t1, Node t2){
        if(t2 == null)
            return true;
        return isSubTree(t1, t2);
    }
    private boolean isSubTree(Node t1, Node t2){
        if(t1 == null)
            return false;
        if(t1.data == t2.data && isTreeSame(t1, t2))
            return true;
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    private boolean isTreeSame(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1.data != root2.data)
            return false;

        return isTreeSame(root1.left, root2.left) && isTreeSame(root1.right, root2.right);
    }
}
