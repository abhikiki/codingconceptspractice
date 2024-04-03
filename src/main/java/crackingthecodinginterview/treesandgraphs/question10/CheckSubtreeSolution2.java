package crackingthecodinginterview.treesandgraphs.question10;

public class CheckSubtreeSolution2 {
    //Time Complexity: O(N + M)
    //Space Complexity: O(N + M)
    public boolean containsTree(Node t1, Node t2){
       StringBuilder flatT1 = new StringBuilder();
       StringBuilder flatT2 = new StringBuilder();
       preOrder(t1, flatT1);
       preOrder(t2, flatT2);
       return flatT1.toString().contains(flatT2.toString());
    }

    private void preOrder(Node root, StringBuilder sb){
        if(root == null) {
            sb.append("X");
            return;
        }
        sb.append(root.data + " ");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
}
