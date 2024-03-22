package crackingthecodinginterview.linkedlists.question2;


import crackingthecodinginterview.linkedlists.Node;

public class DeleteMiddleNodeSolution {

    //Delete a node in the middle(any node but not the first and last node, not exactly middle)
    public void deleteMiddleNode(Node nodeToDelete){
        if(nodeToDelete == null || nodeToDelete.next == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
