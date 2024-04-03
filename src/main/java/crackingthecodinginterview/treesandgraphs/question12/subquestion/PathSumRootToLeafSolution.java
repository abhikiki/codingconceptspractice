package crackingthecodinginterview.treesandgraphs.question12.subquestion;

import java.util.ArrayList;
import java.util.List;

import crackingthecodinginterview.treesandgraphs.question12.Node;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 */
public class PathSumRootToLeafSolution {

    //O()
    public boolean hasPathSum(Node root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(Node root, int targetSum, int currentSum){
        if(root == null)
            return false;
        currentSum += root.data;
        if(isLeafNode(root) && currentSum == targetSum)
            return true;
        return hasPathSum(root.left, targetSum, currentSum)
               || hasPathSum(root.right, targetSum, currentSum) ;
    }

    private boolean isLeafNode(Node root){
        return root.left == null && root.right == null;
    }

    public List<List<Node>> findPathSum(Node root, int targetSum) {
        List<List<Node>> results = new ArrayList<>();
        findPathSum(root, targetSum, 0, results, new ArrayList<>());
        return results;
    }

    private void findPathSum(Node root, int targetSum, int currentSum, List<List<Node>> results, ArrayList<Node> currentList) {
        if(root == null)
            return;
        currentList.add(root);
        currentSum += root.data;

        if(isLeafNode(root) && currentSum == targetSum){
            results.add((ArrayList<Node>)currentList.clone());
        }
        findPathSum(root.left, targetSum, currentSum, results, currentList);
        findPathSum(root.right, targetSum, currentSum, results, currentList);
        currentList.remove(root);
    }
}
