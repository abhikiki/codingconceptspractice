package crackingthecodinginterview.linkedlists.question6;

import java.util.Stack;

import crackingthecodinginterview.linkedlists.Node;
import crackingthecodinginterview.linkedlists.question5.SumListsSolution;

public class PalindromeCheckerSolution {
    /**
     * Check Palindrome
     1-2-3-2-1
     1-2-2-1
     1-2-3-4-5

     */

    public boolean isPalindrome(Node head){
        Stack<Node> stk = new Stack<>();
        Node curr = head;
        while(curr != null){
            stk.add(curr);
            curr = curr.next;
        }
        int totalCount = stk.size();
        int count = 0;
        curr = head;
        while(count < totalCount/2){
            if(curr.data != stk.pop().data)
                return false;
            count++;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1).appendToTail(2).appendToTail(3).appendToTail(2).appendToTail(1);
        PalindromeCheckerSolution sol = new PalindromeCheckerSolution();
        System.out.println(sol.isPalindrome(head));
    }
}
