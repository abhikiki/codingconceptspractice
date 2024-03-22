package crackingthecodinginterview.linkedlists.question1;

import crackingthecodinginterview.linkedlists.Node;

public class RemoveDuplicatesSolution2 {

    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    public Node removeDuplicates(Node head){
        Node curr = head;
        while(curr != null){
            Node prev = curr;
            Node trav = curr.next;
            while(trav != null){
                if(curr.data == trav.data){
                    prev.next = trav.next;
                }
                prev = trav;
                trav = trav.next;
            }
            curr = curr.next;
        }

        return head;
    }

    public void traverseList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(10).appendToTail(10).appendToTail(20).appendToTail(30).appendToTail(20);
        RemoveDuplicatesSolution1 sol = new RemoveDuplicatesSolution1();
        Node head = sol.removeDuplicates(n);
        sol.traverseList(head);
    }
}

