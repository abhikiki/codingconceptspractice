package crackingthecodinginterview.stackandqueues.question3;

import java.util.ArrayList;
import java.util.LinkedList;

public class SetOfStackSolution {
    private static final int SINGLE_STACK_SIZE = 5;
    private ArrayList<LinkedList<Integer>> stackSet = new ArrayList<>();

    public boolean isEmpty() {
        return stackSet.isEmpty();
    }

    public void push(int data){
        if(stackSet.isEmpty() || isLastStackFull()) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addFirst(data);
            stackSet.add(list);
        }else{
            stackSet.get(stackSet.size() - 1).addFirst(data);
        }

    }

    private boolean isLastStackFull() {
        return stackSet.get(stackSet.size() - 1).size() == SINGLE_STACK_SIZE;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        LinkedList<Integer> list = stackSet.get(stackSet.size() - 1);
        int deleteData = list.removeFirst();
        if(list.isEmpty()) {
            stackSet.remove(list);
        }
        return deleteData;
    }

    public int popAt(int index) {
        if(isEmpty() || index > stackSet.size() - 1){
            throw new IllegalStateException("Stack is empty or index outside range");
        }
        LinkedList<Integer> list = stackSet.get(index);
        int deleteData = list.removeFirst();
        if(list.isEmpty()) {
            stackSet.remove(list);
        }
        return deleteData;
    }

    public static void main(String[] args) {
        SetOfStackSolution sol = new SetOfStackSolution();
        sol.push(50);
        sol.push(80);
        sol.push(10);
        sol.push(100);
        sol.push(1);
        sol.push(8);
        System.out.println(sol.pop());
        System.out.println(sol.pop());
        System.out.println(sol.pop());
    }
}
