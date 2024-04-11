package crackingthecodinginterview.recursionanddynamicprogramming.question8;

import java.util.ArrayList;

public class PowerSetSolution {

    public ArrayList<ArrayList<Integer>> generatePowerSet(int n){
        if (n <= 0){
            ArrayList<ArrayList<Integer>> emptyList = new ArrayList<>();
            emptyList.add(new ArrayList<>());
            return emptyList;
        }
        ArrayList<ArrayList<Integer>> subList = generatePowerSet(n - 1);
        ArrayList<ArrayList<Integer>> results = (ArrayList<ArrayList<Integer>>)subList.clone();
        for(ArrayList<Integer> prev : subList){
            ArrayList<Integer> temp = (ArrayList<Integer>)prev.clone();
            temp.add(n);
            results.add(temp);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new PowerSetSolution().generatePowerSet(4));
    }
}
