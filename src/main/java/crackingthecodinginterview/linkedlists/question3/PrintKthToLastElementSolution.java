package crackingthecodinginterview.linkedlists.question3;

import crackingthecodinginterview.linkedlists.Node;

public class PrintKthToLastElementSolution {

    public int printKthToLastRecursive(Node head, int k){
        if(head == null)
            return 0;
        int index = printKthToLastRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(head.data);
        }
        return index;
    }

    /**
     *   Time Complexity: O(N) where N=length of the linked list
     *   Space Complexity: O(1)
     */
    public void printKthToLast(Node head, int k) {
        if(k<1 || head == null)
            throw new IllegalArgumentException("Invalid Input");

        Node curr = head;
        while(curr != null && (k -1) > 0) {
            curr = curr.next;
            k--;
        }
        if(curr == null){
            throw new IllegalArgumentException("K is greater than length of the list");
        }
        traverseList(curr);
    }

    private void traverseList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        PrintKthToLastElementSolution sol = new PrintKthToLastElementSolution();
        Node n = new Node(3).appendToTail(5).appendToTail(8).appendToTail(5).appendToTail(10)
                .appendToTail(2).appendToTail(1);
        System.out.println("Printing kth to last element:");
        sol.printKthToLast(n, 7);

        n = new Node(3).appendToTail(5).appendToTail(8).appendToTail(5).appendToTail(10)
                .appendToTail(2).appendToTail(1);
//        sol.printKthToLast(n, 8);
        sol.printKthToLastRecursive(n, 3);
    }
}
