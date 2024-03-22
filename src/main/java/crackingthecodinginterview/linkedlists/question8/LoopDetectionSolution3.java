package crackingthecodinginterview.linkedlists.question8;

import java.util.LinkedList;

import crackingthecodinginterview.linkedlists.Node;

public class LoopDetectionSolution3 {

    //Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public Node findLoopStartingPoint(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null || slow == null) // no loop
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // starting point
    }

}
