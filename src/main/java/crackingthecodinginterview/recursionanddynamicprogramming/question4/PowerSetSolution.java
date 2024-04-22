package crackingthecodinginterview.recursionanddynamicprogramming.question4;

import java.util.ArrayList;

/**
 Power Set: Write a method to return all subsets of a set.
 */
public class PowerSetSolution {
    /**
     *
     * 0: ()
     1: () 1
     2: () 1 2 (1,2)
     */
    //TimeComplexity: O(N*2^N)
    //SpaceComplexity: O(2^N)
    public ArrayList<ArrayList<Integer>> powerSet(int n){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(n < 0){
            return results;
        }
        if(n == 0){
            results.add(new ArrayList<>());
            return results;
        }
        ArrayList<ArrayList<Integer>> prevResults = powerSet(n-1);
        results.addAll((ArrayList<ArrayList<Integer>>)prevResults.clone());
        for(ArrayList<Integer> prevResult : prevResults){
            ArrayList<Integer> clonedPrevResult = (ArrayList<Integer>)prevResult.clone();
            clonedPrevResult.add(n);
            results.add(clonedPrevResult);
        }

        return results;
    }


    public static void main(String[] args) {
        System.out.println(new PowerSetSolution().powerSet(3));
    }
}
