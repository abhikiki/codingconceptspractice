package crackingthecodinginterview.recursionanddynamicprogramming.question1;

/*
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStepSolution {
    /**
     Time Complexity: O(3^n)
     Space Complexity: O(n);
     Note: We can additionally use memonization to reduce runtime complexity
     */
    public int countWays(int n){
        if(n < 0)
            return 0;
        if(n == 0 || n == 1)
            return 1;
        return countWays(n - 1) + countWays(n-2) + countWays(n-3);
    }

    /**
     Time Complexity: O(3^n)
     Space Complexity: O(n);
     n=1 =1
     n=2 (1,1) (2) =2
     n=3 (1,1,1) (1,2) (2,1) = 4
     n=4 (1,1,1,1) (1,1,2)(1,2,1)(2,1,1)(2,2)(1,3)(3,1) = 7
     f(n) = f(n-3) + f(n-2) + f(n-1);

     TimeComplexity:O(n)
     SpaceComplexity:O(1)
     */
    public int countWaysBottomUp(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;
        int f1=1, f2=2, f3=4;
        int result = f3;
        for(int i=4; i<=n; i++){
            result = f1 + f2 + f3;
            f1=f2;
            f2=f3;
            f3=result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TripleStepSolution().countWays(1));
        System.out.println(new TripleStepSolution().countWays(2));
        System.out.println(new TripleStepSolution().countWays(3));
        System.out.println(new TripleStepSolution().countWays(4));

        System.out.println();

        System.out.println(new TripleStepSolution().countWaysBottomUp(1));
        System.out.println(new TripleStepSolution().countWaysBottomUp(2));
        System.out.println(new TripleStepSolution().countWaysBottomUp(3));
        System.out.println(new TripleStepSolution().countWaysBottomUp(4));
    }
}
