package crackingthecodinginterview.stackandqueues.question5;

import java.util.Stack;

public class SortStackSolution {
    // 10-20-5-6-40
    // 40-6-5

    //Time Complexity: O(N^2) where N=total elements in the given stack to be sorted
    //Space complexity: O(N)
    public Stack<Integer> sortStack(Stack<Integer> stk) {
        Stack<Integer> sortedStack = new Stack<>();
        while(!stk.isEmpty()){
            if(sortedStack.isEmpty() || (stk.peek() <= sortedStack.peek())){
                sortedStack.add(stk.pop());
            }else{
                int data = stk.pop();
                while(!sortedStack.isEmpty() && data > sortedStack.peek()){
                    stk.push(sortedStack.pop());
                }
                stk.push(data);
            }
        }
        return sortedStack;
    }

    public static void main(String[] args) {
        SortStackSolution sol = new SortStackSolution();
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(5);
        stk.push(6);
        stk.push(40);
        stk.push(5);
        Stack<Integer> sortedStack = sol.sortStack(stk);
        System.out.println(sortedStack);
    }
}
