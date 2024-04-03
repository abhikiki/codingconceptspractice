package extraquestions;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class SerializeDeserialize {
    public static final String COMMA = ",";
    public static final String NULL_MARKER = "K";

    public String serialize(TreeNode root) {
        if (root == null) return NULL_MARKER;
        return root.val + COMMA + serialize(root.left) + COMMA + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(COMMA)));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue){
        String data = queue.poll();
        if(data.equals(NULL_MARKER)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
//                    10
//           2               3
//4                5      6       7
        SerializeDeserialize ser = new SerializeDeserialize();
        String ss = ser.serialize(n1);
        System.out.println(ser.serialize(n1));
        TreeNode derRoot = ser.deserialize(ss);
        String dd = ser.serialize(derRoot);
        System.out.println(dd);
        System.out.println(ss.equals(dd));
    }
}
