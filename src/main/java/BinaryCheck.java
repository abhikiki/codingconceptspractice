//import  java.lang.*;

public class BinaryCheck {
    // Negate only when `flag` is true
    public static int negate(int n, int flag) {
        return (n ^ -flag) + flag;
    }

    public static boolean powerOfTwo(int n) {
        System.out.println(Integer.toBinaryString(n & (-n)));
        return (n &(-n)) == ((n&(-n))&~0&-1);
    }

    public static void absoluteNumber(int n) {


        final int mask = n >> Integer.SIZE * 8 - 1;

        System.out.println("n (" + n + ") in binary is " + Integer.toBinaryString(n));

        System.out.println("mask (" + mask + ") in binary is " +
                           Integer.toBinaryString(mask));

        System.out.println("n + mask (" + n + mask + ") in binary is " +
                           Integer.toBinaryString(n + mask));

        System.out.println("abs(" + n + ") is " + ((n + mask) ^ mask));
    }

    public static void main(String[] args)
    {
        System.out.println(findPreviousPowerOf2(67));
    }

    public static boolean isOppositeSign(int n1, int n2) {
        return ((n1 >> 31) ^ (n2 >> 31)) != 0;
    }

    // Function to turn off k'th bit in `n`
    public static int turnOffKthBit(int n, int k) {
        //return n & (-1 ^ (1 << (k-1)));
        return n & ~(1 << (k - 1));
    }

    // Compute a power of two less than or equal to `n`
    public static int findPreviousPowerOf2(int n)
    {
        // do till only one bit is left
        while ((n & n - 1) != 0) {
            n = n & n - 1;        // unset rightmost bit
        }


        return n >> 1;
    }
    public static void test(int num1, int num2) {
        System.out.println("A=" + (char)('A' | ' '));

        System.out.println(num1 ^ num2 ^ num2);
        System.out.println(num1 ^ num2 ^ num1);
    }
}
