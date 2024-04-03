package crackingthecodinginterview.treesandgraphs.question12;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSumSolution1 {

    private ArrayList<ArrayList<Node>> allPaths = new ArrayList<>();

    public ArrayList<ArrayList<Node>> pathSum(Node root, int target){
      if(root == null)
          return allPaths;
      pathSum(root, target, 0, new ArrayList<>());
      pathSum(root.left, target);
      pathSum(root.right, target);
      return allPaths;
    }

//    private void pathSum(Node root, int target,  int currentSum, ArrayList<Node> currentPath){
//        if(root == null)
//            return;
//        currentPath.add(root);
//        currentSum += root.data;
//        if(currentSum == target)
//            allPaths.add((ArrayList<Node>) currentPath.clone());
//        pathSum(root.left, target, currentSum, currentPath);
//        pathSum(root.right, target, currentSum, currentPath);
//        currentPath.remove(root);
//    }

    private void pathSum(Node root, int target,  int currentSum, ArrayList<Node> currentPath){
        if(root == null)
            return;
        currentPath.add(root);
        currentSum += root.data;
        if(currentSum == target)
            allPaths.add((ArrayList<Node>) currentPath.clone());
        pathSum(root.left, target, currentSum, currentPath);
        pathSum(root.right, target, currentSum, currentPath);
        currentPath.remove(root);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(35);
        root.left.left = new Node(30);

        PathSumSolution1 sol = new PathSumSolution1();
        ArrayList<ArrayList<Node>> allPaths = sol.pathSum(root, 35);
        for(ArrayList<Node> nodesList :allPaths ) {
            System.out.println("Result List");
            for (Node node : nodesList) {
                System.out.println(node.data);
            }
            System.out.println();
        }
    }
}
