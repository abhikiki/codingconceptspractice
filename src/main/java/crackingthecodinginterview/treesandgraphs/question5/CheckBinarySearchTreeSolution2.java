package crackingthecodinginterview.treesandgraphs.question5;

public class CheckBinarySearchTreeSolution2 {
    Integer lastNodeValue = null;

    //Assumption there are no duplicates
    //Time Complexity: O(N)
    //Space Complexity: O(H) where H = height of the tree
    //In BST inorder traverse tree in ascending order

    public boolean checkBST(Node n){
        if(n == null)
            return true;
        if(!checkBST(n.left))
            return false;
        if(lastNodeValue != null && lastNodeValue > n.data)
            return false;
        lastNodeValue = n.data;

        if(!checkBST(n.right))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Node n30 = new Node(30);
        Node n20 = new Node(20);
        Node n10 = new Node(10);
        Node n45 = new Node(45);
        Node n60 = new Node(60);
        n30.left = n20;
        n30.right = n60;
        n20.left = n10;
        n20.right = n45;

        CheckBinarySearchTreeSolution2 sol = new CheckBinarySearchTreeSolution2();
        System.out.println(sol.checkBST(n30));
    }
}
