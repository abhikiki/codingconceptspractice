package crackingthecodinginterview.linkedlists.question8;

public class LoopDetectionSolution2 {
    //Using marker approach
    class LinkNode{
        int data;
        boolean mark;
        LinkNode next;
    }

    //Time Complexity: O(N)
    public boolean isLoop(LinkNode head){
        LinkNode curr = head;
        while(curr != null){
            if(curr.mark)
                return true;
            curr.mark = true;
            curr = curr.next;
        }
        return false;
    }
}
