package crackingthecodinginterview.bitmanipulation.insertion.question6;

public class BitDifferenceCounterSolution {

    public int bitDifferenceCounter(int a, int b){
        int diff = a ^ b;
        int count = 0;
        while(diff != 0){
            count++;
            diff = diff & (diff -1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BitDifferenceCounterSolution().bitDifferenceCounter(10, 6));
    }
}