package crackingthecodinginterview.treesandgraphs.question8;

/**
 *  Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

public class CommonAncestorSolution {

    public Node findCommonAncestor(Node root, Node target1, Node target2){
        if(!isPath(root, target1) || !isPath(root, target2))
            return null;

        return findCommonAncestorHelper(root, target1, target2);
    }

    private Node findCommonAncestorHelper(Node root, Node p, Node q){
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        boolean pOnLeft = isPath(root.left, p);
        boolean qOnLeft = isPath(root.left, q);
        if(pOnLeft != qOnLeft){
            return root.left;
        }
        Node childNode = pOnLeft ? root.left : root.right;
        return findCommonAncestorHelper(childNode, p, q);
    }

    private boolean isPath(Node from, Node to){
        if(from == null)
            return false;

        if(from == to)
            return true;

        return isPath(from.left, to) || isPath(from.right, to);
    }
}
