package crackingthecodinginterview.treesandgraphs.question6;

/**
 *  Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 */

class Node{
    int data;
    Node left;
    Node right;

    Node parent;

    Node(int data){
        this.data = data;
    }
}

public class InorderSuccessor {

    //Time Complexity: O(N)
    public Node findInorderSuccessor(Node root){
        if(root == null)
            return null;
        if(root.right != null){
            return findLeftMostOfRight(root.right);
        } else{
            Node curr = root;
            while(curr.parent != null && curr.parent.left != curr){
                curr = curr.parent;
            }
            return curr.parent;
        }
    }

    private Node findLeftMostOfRight(Node root){
        Node curr = root;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
