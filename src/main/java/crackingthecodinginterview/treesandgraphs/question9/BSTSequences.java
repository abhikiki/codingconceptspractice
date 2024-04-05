package crackingthecodinginterview.treesandgraphs.question9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

public class BSTSequences {

        private Node root = null;
        public List<LinkedList<Integer>> allSequences(Node root){
            List<LinkedList<Integer>> finalResults = new ArrayList<>();
            if(root == null){
                finalResults.add(new LinkedList<>());
                return finalResults;
            }


            List<LinkedList<Integer>> leftSequences = allSequences(root.left);
            List<LinkedList<Integer>> rightSequences = allSequences(root.right);
            LinkedList<Integer> prefix = new LinkedList<>();
            prefix.add(root.data);

            for(LinkedList<Integer> leftSequence : leftSequences){
                List<LinkedList<Integer>> currentResults = new ArrayList<>();
                for(LinkedList<Integer> rightSequence : rightSequences){
                    weaveSequences(leftSequence, rightSequence, currentResults, prefix);
                    finalResults.addAll(currentResults);
                }
            }
            return finalResults;
        }

        public int numOfWays(int[] nums) {
            buildBST(nums);
            List<LinkedList<Integer>> results = allSequences(root);
            System.out.println(results);
            return allSequences(root).size(); // This also includes given sequence in the input
        }

        private void buildBST(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                root = addData(root, nums[i]);
            }
        }

        private void weaveSequences(
                    LinkedList<Integer> leftSequence,
                    LinkedList<Integer> rightSequence,
                    List<LinkedList<Integer>> currentResults,
                    LinkedList<Integer> prefix){

                if(leftSequence.isEmpty() || rightSequence.isEmpty()){
                    LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
                    result.addAll(leftSequence);
                    result.addAll(rightSequence);
                    currentResults.add(result);
                    return;
                }

                // First list
                int removeFirstLeftSequence = leftSequence.removeFirst();
                prefix.addLast(removeFirstLeftSequence);
                weaveSequences(leftSequence, rightSequence, currentResults, prefix);
                prefix.removeLast();
                leftSequence.addFirst(removeFirstLeftSequence);

                // Second List
                int removeFirstRightSequence = rightSequence.removeFirst();
                prefix.addLast(removeFirstRightSequence);
                weaveSequences(leftSequence, rightSequence, currentResults, prefix);
                prefix.removeLast();
                rightSequence.addFirst(removeFirstRightSequence);
            }

        private Node addData(Node root, int currentData){
            Node newNode = new Node(currentData);
            if(root == null){
                root = newNode;
            } else{
                if(currentData <= root.data){
                    if(root.left == null){
                        root.left = newNode;
                    } else{
                        addData(root.left, currentData);
                    }
                } else{
                    if(root.right == null){
                        root.right = newNode;
                    } else{
                        addData(root.right, currentData);
                    }
                }
            }
            return root;
        }

        public static void main(String[] args) {
            System.out.println(new BSTSequences().numOfWays(new int[]{1,2,3}));
        }
}
