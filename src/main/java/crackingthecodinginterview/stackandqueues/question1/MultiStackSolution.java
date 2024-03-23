package crackingthecodinginterview.stackandqueues.question1;

import java.util.Arrays;

public class MultiStackSolution {
    private int stackCount = 3;
    private int stackSize = 10;
    private int[] stackData;
    private int[] stackStartPointer;
    private int[] stackEndPointer;
    public MultiStackSolution(){
        this(3, 10);
    }

    //Time Complexity: O(1)
    //Space Complexity: O(stackCount * stackSize + 2*stackCount) approx O(stackCount * stackSize)
    public MultiStackSolution(int stackCount, int stackSize){
        this.stackSize = stackSize;
        this.stackCount = stackCount;
        stackData = new int[stackCount * stackSize];
        stackStartPointer = new int[stackCount];
        stackEndPointer = new int[stackCount];
        Arrays.fill(stackStartPointer, -1);
        Arrays.fill(stackEndPointer, -1);
    }

    public void push(int stackNumber, int data){ // Stack number starts with 1 onwards
        if(!isStackNumberValid(stackNumber) || isFull(stackNumber))
            throw new IllegalStateException("Stack is full");
        if(stackStartPointer[stackNumber-1] == -1){
            stackStartPointer[stackNumber-1] = stackSize * (stackNumber - 1);
            stackEndPointer[stackNumber-1] = stackStartPointer[stackNumber-1];
        } else{
            stackEndPointer[stackNumber-1]++ ;
        }
        stackData[stackEndPointer[stackNumber-1]] = data;

    }

    public int pop(int stackNumber){
        if(!isStackNumberValid(stackNumber) || isEmpty(stackNumber))
            throw new IllegalStateException("Stack is empty");

        int poppedData = stackData[stackEndPointer[stackNumber-1]];

        stackEndPointer[stackNumber-1]--;
        if(stackEndPointer[stackNumber-1] == (stackNumber - 1) * stackSize - 1){
            stackStartPointer[stackNumber-1] = -1;
            stackEndPointer[stackNumber-1] = -1;
        }
        return poppedData;
    }

    private boolean isEmpty(int stackNumber){
        return stackStartPointer[stackNumber-1] == -1;
    }

    private boolean isFull(int stackNumber){
        return stackEndPointer[stackNumber-1] == stackSize * stackNumber - 1;
    }

    private boolean isStackNumberValid(int stackNumber){
        return stackNumber > 0;
    }

    public static void main(String[] args) {
        MultiStackSolution sol = new MultiStackSolution(3,3);
        sol.push(3, 10);
        sol.push(3, 11);
        sol.push(3, 12);
        System.out.println(sol.pop(3));
        System.out.println(sol.pop(3));
        System.out.println(sol.pop(3));
        sol.push(3, 14);
        System.out.println(sol.pop(3));
    }
}
