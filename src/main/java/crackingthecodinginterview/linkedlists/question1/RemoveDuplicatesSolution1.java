package crackingthecodinginterview.linkedlists.question1;

import java.util.HashSet;

import crackingthecodinginterview.linkedlists.Node;


//Write a code to remove duplicates from unsorted linked list
public class RemoveDuplicatesSolution1 {

    HashSet<Integer> hset = new HashSet<>();

    //Time Complexity: O(N) N=length of linked list
    //Space Complexity: O(N) N=length of linked list
    public Node removeDuplicates(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            if(hset.contains(curr.data)){
                prev.next = curr.next;
            }else{
                hset.add(curr.data);
            }
            prev = curr;
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
