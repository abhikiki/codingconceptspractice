package crackingthecodinginterview.bitmanipulation.insertion.question1;

public class BitsInsertionSolution {

    public int bitsInsertion(int m, int n, int start, int end){
        int leftMask = -1 << (end + 1); // we can also use ~0 instead of -1 as ~0 = -1
        //int rightMask = -1 >>> (Integer.BYTES * 8 - start); This also works
         int rightMask = (-1 << start) - 1;
        int finalMask = leftMask | rightMask;
        return (n & finalMask) | (m << start);
    }

    public static void main(String[] args) {
        /**
         *  100000
         *  111000
         *  000001
         *  111001
         *  000110
         *  100110
         */
        System.out.println(new BitsInsertionSolution().bitsInsertion(3, 32, 1, 2));
    }
}
