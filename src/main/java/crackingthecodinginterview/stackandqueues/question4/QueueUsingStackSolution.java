package crackingthecodinginterview.stackandqueues.question4;

import java.util.Stack;

public class QueueUsingStackSolution<T> {
    private Stack<T> stk1 = new Stack<>();
    private Stack<T> stk2 = new Stack<>();

    //O(1)
    public void addQueue(T data){
        stk1.add(data);
    }

    //O(N)
    public T delQueue() {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");
        if(!stk2.isEmpty()){
            return stk2.pop();
        }

        shiftStack(stk1, stk2);
        return stk2.pop();
    }

    //O(N)
    public T peek(){
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");
        if(!stk2.isEmpty()){
            return stk2.peek();
        }

        shiftStack(stk1, stk2);
        return stk2.peek();
    }

    private boolean isEmpty(){
        return stk1.isEmpty() && stk2.isEmpty();
    }

    private void shiftStack(Stack<T> fromStk, Stack<T> toStk){
        while(!fromStk.isEmpty()){
            toStk.add(fromStk.pop());
        }
    }

    public static void main(String[] args) {
        QueueUsingStackSolution sol = new QueueUsingStackSolution();
        sol.addQueue(1);
        sol.addQueue(2);
        sol.addQueue(3);
        System.out.println(sol.delQueue());//1
        sol.addQueue(4);
        System.out.println(sol.peek()); //2
        System.out.println(sol.delQueue());//2
        sol.addQueue(5);
        sol.addQueue(6);
        System.out.println(sol.peek()); //3

    }
}
