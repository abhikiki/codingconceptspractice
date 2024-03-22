package crackingthecodinginterview.linkedlists.question4;

import crackingthecodinginterview.linkedlists.Node;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before
 * all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the
 * elements less than x (see below). The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5] Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class ListPartitionSolution1 {

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public Node partitionList(Node head, int partitionNumber) {
        if(head == null)
            throw new IllegalArgumentException("Invalid input");
        NodeHeadTail leftNodeHeadTail = null;
        NodeHeadTail rightNodeHeadTail = null;
        Node curr = head;
        while(curr != null){
            if(curr.data < partitionNumber) {
                leftNodeHeadTail = addNode(leftNodeHeadTail, curr.data);
            }else{
                rightNodeHeadTail = addNode(rightNodeHeadTail, curr.data);
            }
            curr = curr.next;
        }
        curr = leftNodeHeadTail.head;
        while(curr != null && curr.next != null){
            curr = curr.next;
        }
        if(leftNodeHeadTail.head != null && rightNodeHeadTail != null)
            curr.next = rightNodeHeadTail.head;
        return leftNodeHeadTail.head;
    }

    private NodeHeadTail addNode(NodeHeadTail nodeHeadTail, int data) {
        Node n = new Node(data);
        if(nodeHeadTail == null) {
            return new NodeHeadTail(n,n);
        }
        nodeHeadTail.tail.next = n;
        nodeHeadTail.tail = n;
        return nodeHeadTail;
    }

    public void traverseList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(20).appendToTail(10).appendToTail(30).appendToTail(20).appendToTail(50);
        ListPartitionSolution1 sol = new ListPartitionSolution1();
        Node head = sol.partitionList(n, 30);
        System.out.println("Example: 1");
        sol.traverseList(head);

        System.out.println("Example: 1");
        n = new Node(20).appendToTail(10).appendToTail(30);
        head = sol.partitionList(n, 40);
        sol.traverseList(head);

        System.out.println("Example: 3");
        n = new Node(3).appendToTail(5).appendToTail(8).appendToTail(5).appendToTail(10)
                .appendToTail(2).appendToTail(1);
        head = sol.partitionList(n, 5);
        sol.traverseList(head);
    }

    class NodeHeadTail {
        Node head;
        Node tail;
        NodeHeadTail(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
