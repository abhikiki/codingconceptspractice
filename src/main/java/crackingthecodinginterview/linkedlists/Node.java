package crackingthecodinginterview.linkedlists;

/**
 * Common linked list operations
 */
public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node appendToTail(int data) {
        Node n = new Node(data);
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
        return this;
    }
}
