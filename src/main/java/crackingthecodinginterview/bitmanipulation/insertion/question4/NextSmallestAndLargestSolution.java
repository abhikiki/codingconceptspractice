package crackingthecodinginterview.bitmanipulation.insertion.question4;

public class NextSmallestAndLargestSolution {

    // n is +ve integer
    public int nextBigger(int n){
        if(n == 0)
            return -1;
        int zeroCount = 0;
        int oneCount = 0;
        int curr = n;
        while((curr & 1) == 0 && curr != 0){
            curr = curr >> 1;
            zeroCount++;
        }

        while((curr & 1) == 1){
            curr = curr >> 1;
            oneCount++;
        }

        if(zeroCount + oneCount == (Integer.BYTES * 8 - 1)){
            return -1;
        }

        int p = zeroCount + oneCount;
        //flip p value
        n |= 1 << p;
        n &= ~((1 << p) - 1);
        n |= (1 << (p-1)) - 1;

        return n;
    }

    public int nextSmaller(int n) {
        if (n == 0)
            return -1;
        int zeroCount = 0;
        int oneCount = 0;
        int curr = n;
        while ((curr & 1) == 1) {
            curr = curr >> 1;
            oneCount++;
        }
        if (curr == 0)
            return -1;
        while ((curr & 1) == 0 && curr != 0) {
            curr = curr >> 1;
            zeroCount++;
        }
//        0010 1011
        int p = oneCount + zeroCount;
        n &= ~((1 << (p + 1)) - 1);
        n |= ((1 << (oneCount + 1)) - 1) << (zeroCount - 1);
        return n;
    }

    public static void main(String[] args) {
        NextSmallestAndLargestSolution sol = new NextSmallestAndLargestSolution();
        System.out.println(sol.nextBigger(43));
        System.out.println(sol.nextSmaller(43));
    }
}
