package crackingthecodinginterview.linkedlists.question7;

import crackingthecodinginterview.linkedlists.Node;
import crackingthecodinginterview.linkedlists.question6.PalindromeCheckerSolution;

public class ListIntersectionSolution {

    /**
     * 1-2-3-4-5-6-7-8-9 9
     *       1-2-3  7
     * @param head1
     * @param head2
     * @return
     */
    public Node listIntersection(Node head1, Node head2){
        int len1 = length(head1);
        int len2 = length(head2);
        if(len1 == 0 || len2 == 0)
            return null;
        Node longHead = len2 > len1 ? head2 : head1;
        Node shortHead = len2 > len1 ? head1 : head2;
        int diff = Math.abs(len2-len1);
        while(longHead != null && diff > 0){
            diff = diff -1;
            longHead = longHead.next;
        }
        while(longHead != null && shortHead != null){
            if(longHead == shortHead)
                return longHead;
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    private int length(Node head){
        int len = 0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
}
