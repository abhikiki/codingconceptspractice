package crackingthecodinginterview.linkedlists.question5;

import crackingthecodinginterview.linkedlists.Node;
import crackingthecodinginterview.linkedlists.question4.ListPartitionSolution1;

public class SumListsSolution {
    /**
     1-2-3-5 result =     2-0-2-4
     7-8-9
     // Time Complexity: O(N1 + N2)
     // Space Complexity: O(N1 + N2)
     */
    public Node sumLists(Node head1, Node head2){
        if(head1 == null || head2 == null)
            throw new IllegalArgumentException("Invalid input");
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int carry = 0;
        Node result = null;
        while(head1 != null && head2 != null){
            int sum = head1.data + head2.data + carry;
            int digit = sum % 10;
            carry = sum/10;
            result = appendToTail(result, digit);
            head1 = head1.next;
            head2 = head2.next;
        }

        Node curr = head1 == null ? head2 : head1;
        while(curr != null){
            int sum = curr.data + carry;
            int digit = sum % 10;
            carry = sum/10;
            result = appendToTail(result, digit);
            curr = curr.next;
        }
        if(carry != 0){
            result = appendToTail(result, carry);
        }
        return reverseList(result);

    }

    private Node appendToTail(Node head, int data){
        Node n = new Node(data);
        if(head == null)
            return n;

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = n;
        return head;
    }

    private Node reverseList(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void traverse(Node head) {
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;

        }
    }
    public static void main(String[] args) {
        Node head1 = new Node(1).appendToTail(2).appendToTail(3).appendToTail(5);
        Node head2 = new Node(7).appendToTail(8).appendToTail(9);
        SumListsSolution sol = new SumListsSolution();
        Node head = sol.sumLists(head1, head2);

        sol.traverse(head);
    }
}
