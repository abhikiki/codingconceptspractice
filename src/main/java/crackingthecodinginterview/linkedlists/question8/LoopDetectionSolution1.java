package crackingthecodinginterview.linkedlists.question8;

import java.util.HashSet;

import crackingthecodinginterview.linkedlists.Node;
import crackingthecodinginterview.linkedlists.question6.PalindromeCheckerSolution;

public class LoopDetectionSolution1 {

    // Using HashSet approach
    //Time Complexity: O(N) N = length of linked list
    //Space Complexity: O(N)
    public boolean isLoop(Node head){
        Node curr = head;
        HashSet<Node> hset = new HashSet<>();
        while(curr != null){
            if(hset.contains(curr)){
                return true;
            }
            hset.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
