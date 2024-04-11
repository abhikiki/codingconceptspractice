package crackingthecodinginterview.recursionanddynamicprogramming.question11;

public class CoinWaysSolution {

    private static final int[] demos = new int[]{25,10,5,1};
    public int coinWays(int sum){
        if(sum == 0)
            return 0;
        return coinWaysHelper(sum, demos.length - 1);
    }

//    [5,1] sum = 6
    //Time Complexity: O(2^sum)
    //Space Complexity: O(sum)
    private int coinWaysHelper(int sum, int index){
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return 0;
        }
        if(index < 0 ){
            return 0;
        }
        //find ways with previous denominations
        int previousWays = coinWaysHelper(sum, index - 1);
        //find ways with current denomination;
        previousWays += coinWaysHelper(sum - demos[index], index);


        return previousWays;
    }

    // 6 5 2, 1

//    7
//
//    7 (6,5,2)
//            7(6,5)
    public static void main(String[] args) {
        System.out.println(new CoinWaysSolution().coinWays(6));
    }
}
