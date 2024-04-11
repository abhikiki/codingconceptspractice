package crackingthecodinginterview.treesandgraphs.question11;

import java.util.Random;

/**
 * Random Node: You are implementing a binary tree class from scratch which, in addition to
 * insert, find, and delete, has a method getRandomNode() which returns a random node
 * from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for getRandomNode, and explain how you would implement the rest of the methods.
 */

class Node {
    int data;
    int size;

    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class RandomNumberSolution {
    Node root;

    public Node getRandomNode(){
        if(root == null)
            return null;
        return getRandomNode(root);
    }

    public void insertData(int data){
        root = insertData(root, data);
    }
    private Node insertData(Node root, int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            root.size++;
            return root;
        }
        if(data <= root.data){
            if(root.left != null){
                root.left = insertData(root.left, data);
            }else{
                root.left = newNode;
                root.left.size++;
            }
        }else{
            if(root.right != null){
                root.right = insertData(root.right, data);
            }else{
                root.right = newNode;
                root.right.size++;
            }
        }
        root.size++;
        return root;
    }

    private Node getRandomNode(Node root){
        Random rnd = new Random();
        int number = rnd.nextInt(root.size) + 1;
        if(number == root.size)
            return root;
        if(number < root.size &&  root.left !=null) {
            return getRandomNode(root.left);
        } else{
            return getRandomNode(root.right);
        }
    }

    public static void main(String[] args) {
        RandomNumberSolution sol = new RandomNumberSolution();
        sol.insertData(50);
        sol.insertData(30);
        sol.insertData(20);
        sol.insertData(25);
        sol.insertData(60);
        sol.insertData(55);

        Node n1 = sol.getRandomNode();
        Node n2 = sol.getRandomNode();
        Node n3 = sol.getRandomNode();
        Node n4 = sol.getRandomNode();
        System.out.println(n1.data);
        System.out.println(n2.data);
        System.out.println(n3.data);
        System.out.println(n4.data);
    }
}
