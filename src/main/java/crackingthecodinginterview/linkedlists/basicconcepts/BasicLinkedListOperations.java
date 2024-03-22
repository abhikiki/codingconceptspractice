package crackingthecodinginterview.linkedlists.basicconcepts;

import crackingthecodinginterview.linkedlists.Node;

public class BasicLinkedListOperations {
    public int length(Node head) {
        int count=0;
        Node trav = head;
        while(trav != null) {
            trav = trav.next;
            count++;
        }
        return count;
    }

    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void traverseList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    // 1-2-3-4 middle node we return the later part i.e 3
    // 1-2-3-4-5 middle node is 3
    public Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        BasicLinkedListOperations sol = new BasicLinkedListOperations();
        Node head = new Node(10);
        head.appendToTail(20).appendToTail(30).appendToTail(40).appendToTail(50).appendToTail(60);


        Node middleNode = sol.findMiddleNode(head);
        System.out.println("Middle node=" + middleNode.data);
        Node reverseHead = sol.reverse(head);
        sol.traverseList(reverseHead);

    }
}
