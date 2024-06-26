package crackingthecodinginterview.recursionanddynamicprogramming.question11;

import java.util.Arrays;

public class CoinWaysSolution {


    private static final int[] demons = new int[]{10,5,3,1};

    public int coinWays(int sum){
        if(sum == 0)
            return 0;
        return coinWaysHelper(sum, demons.length - 1);
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
        previousWays += coinWaysHelper(sum - demons[index], index);


        return previousWays;
    }



    // Below approach only works when denominations are in sorted array descending
    int makeChange(int n) {
         int[] denoms = {25, 10, 5, 1};
         return makeChange(n , 0);
         }

    int makeChange(int amount, int index) {

        if (index >= demons.length - 1) return 1; //last denom

        int denomAmount = demons[index];
        int ways = 0;
        for (int i= 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways+= makeChange(amountRemaining, index + 1);
        }
        return ways;
    }

    public int dpSolution(int sum){
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int j=0; j<demons.length; j++) {
            for (int i = 0; i <= sum; i++) {
                if (i - demons[j] >= 0) {
                    dp[i] += dp[i - demons[j]];
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(new CoinWaysSolution().coinWays(26));
        System.out.println(new CoinWaysSolution().makeChange(26));
        System.out.println(new CoinWaysSolution().dpSolution(26));
    }
}
