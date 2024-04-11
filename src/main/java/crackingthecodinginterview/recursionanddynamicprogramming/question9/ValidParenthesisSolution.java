package crackingthecodinginterview.recursionanddynamicprogramming.question9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ValidParenthesisSolution {

    int count = 0;
    ArrayList<String> findValidParenthesis(final int n){
        if(n == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }
        return findValidParenthesisHelper(n);
    }

    private ArrayList<String>  findValidParenthesisHelper(int n){
        System.out.println(count++);
        if(n == 1){
            ArrayList<String> results = new ArrayList<>();
            results.add("()");
            return results;
        }
        ArrayList<String> prevResults = findValidParenthesisHelper(n-1);
        ArrayList<String> currentResults = new ArrayList<>();

        for(String preResult : prevResults){
            for(int i=0; i< preResult.length(); i++){
                currentResults.add(preResult.substring(0, i) + "()"+ preResult.substring(i));
            }
        }
        return currentResults;
    }

    public static void main(String[] args) {
        ValidParenthesisSolution sol = new ValidParenthesisSolution();
        System.out.println(sol.findValidParenthesis(3));
    }
}
