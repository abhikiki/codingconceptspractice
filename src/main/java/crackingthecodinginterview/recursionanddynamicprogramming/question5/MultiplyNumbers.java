package crackingthecodinginterview.recursionanddynamicprogramming.question5;

public class MultiplyNumbers {
    public int multiply(int larger, int smaller) {
        if(smaller == 0)
            return 0;
        if(smaller == 1)
            return larger;
        if(larger < smaller)
            return multiply(smaller, larger);

        int half =  smaller >> 1; // divide to half
        int halfSum = multiply(larger, half);
        int result = halfSum + halfSum;
        if((smaller & 1) != 0) { // odd
            result += larger;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyNumbers().multiply(20,30));
        System.out.println(new MultiplyNumbers().multiply(20,31));
    }
}
