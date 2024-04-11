package crackingthecodinginterview.bitmanipulation.insertion.question7;

public class PairwiseSwapSolution {

    public int pairWiseBitSwap(int n){
        return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        PairwiseSwapSolution sol = new PairwiseSwapSolution();
        System.out.println(sol.pairWiseBitSwap(23));
    }
}
