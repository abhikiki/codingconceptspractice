package crackingthecodinginterview.stackandqueues;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        // Push onto stack1
        stackNewest.push(value);
    }

    /* Move elements from stackNewest into stackOldest. This is usually done so that we can
     * do operations on stackOldest.
     */
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek(); // retrieve the oldest item.
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop(); // pop the oldest item.
    }

     public static void main(String[] args) {
         MyQueue sol = new MyQueue();
            sol.add(1);
            sol.add(2);
            sol.add(3);
            System.out.println(sol.remove());//1
            sol.add(4);
            System.out.println(sol.peek()); //2
            System.out.println(sol.remove());//2            sol.add(5);
            sol.add(6);
            System.out.println(sol.peek()); //3

        }

}
