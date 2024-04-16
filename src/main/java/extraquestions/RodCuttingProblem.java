package extraquestions;

public class RodCuttingProblem {

    public int maxRevenue(int[] prices, int rodSize){
        return maxRevenueHelper(prices,  rodSize);
    }

    private int maxRevenueHelper(int[] prices, int rodSize){
        if(rodSize <= 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<rodSize ; i++){
            if(i < prices.length)
                max = Math.max(max, prices[i] + maxRevenueHelper(prices, rodSize - i -1));
        }
        return max;
    }

    public int minRevenue(int[] prices, int rodSize){
        return minRevenueHelper(prices,  rodSize);
    }

    private int minRevenueHelper(int[] prices, int rodSize){
        if(rodSize <= 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<rodSize ; i++){
            if(i < prices.length)
                min = Math.min(min, prices[i] + minRevenueHelper(prices, rodSize - i -1));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new RodCuttingProblem().maxRevenue(new int[]{1,5,8,9}, 6));
        System.out.println(new RodCuttingProblem().minRevenue(new int[]{5,3,4,9}, 6));
    }
}
