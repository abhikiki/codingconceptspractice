package crackingthecodinginterview.recursionanddynamicprogramming.question5;

public class MultiplyNumbers {

    /**
     * Write a recursive function to multiply two integers without using the *operator.
     * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
     * @param larger
     * @param smaller
     * @return
     */
    /**
     * TimeCOmplexity: Log(S) where S is the smaller number
     */

    public int recursiveMultiply(int num1, int num2){
        if(num1 == 0 || num2 == 0)
            return 0;

        int result = recursiveMultiplyHelper(Math.abs(num1), Math.abs(num2));
        return (num1 ^ num2) > 0 ? result : -result;
    }


    private int recursiveMultiplyHelper(int larger, int smaller) {
        if(smaller == 1)
            return larger;
        if(larger < smaller)
            return recursiveMultiplyHelper(smaller, larger);

        int halfSum = recursiveMultiplyHelper(larger, smaller >> 1);
        int result = halfSum + halfSum;
        if((smaller & 1) == 1) { // odd
            result += larger;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyNumbers().recursiveMultiply(30,20));
        System.out.println(new MultiplyNumbers().recursiveMultiply(20,31));
        System.out.println(new MultiplyNumbers().recursiveMultiply(2, 4));
        System.out.println(new MultiplyNumbers().recursiveMultiply(2, -4));
        System.out.println(new MultiplyNumbers().recursiveMultiply(-2, -4));
        System.out.println(new MultiplyNumbers().recursiveMultiply(-2, 4));
        System.out.println(new MultiplyNumbers().recursiveMultiply(5, 3));
    }
}
