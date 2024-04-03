package crackingthecodinginterview.treesandgraphs.question5;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
public class CheckBinarySearchTreeSolution1 {
    //Time Complexity: O(N)
    //Space Complexity: O(H) height of the treez
    public boolean checkBST(Node n){
        return checkBST(n, null, null);
    }

    private boolean checkBST(Node n , Integer min, Integer max){
        if(n == null)
            return true;
        System.out.println("Min=" + min + " Max=" + max + " data=" + n.data);
        if( (min != null && n.data <= min) || max != null && n.data > max )
            return false;

        System.out.println("valid level");
        return checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max);
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

        CheckBinarySearchTreeSolution1 sol = new CheckBinarySearchTreeSolution1();
        System.out.println(sol.checkBST(n30));
    }
}
