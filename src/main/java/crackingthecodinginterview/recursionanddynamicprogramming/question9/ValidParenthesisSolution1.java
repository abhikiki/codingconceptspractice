package crackingthecodinginterview.recursionanddynamicprogramming.question9;

import java.util.HashSet;
import java.util.Set;

public class ValidParenthesisSolution1 {

    public Set<String> printValidParenthesis(int n){
        Set<String> results = new HashSet<>();
        if(n <=0)
            return results;
        return printValidParenthesisHelper(n);
    }

    private Set<String> printValidParenthesisHelper(int n){
        Set<String> results = new HashSet<>();
        if(n == 1){
            results.add("()");
            return results;
        }
        Set<String> prevResults = printValidParenthesisHelper(n-1);
        for(String prevResult : prevResults){
            for(int i=0; i<prevResult.length(); i++){
                results.add(prevResult.substring(0,i) + "()" + prevResult.substring(i));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ValidParenthesisSolution1 sol = new ValidParenthesisSolution1();
        System.out.println(sol.printValidParenthesis(1).size());
        System.out.println(sol.printValidParenthesis(2).size());
        System.out.println(sol.printValidParenthesis(3).size());
        System.out.println(sol.printValidParenthesis(4).size());
        System.out.println(sol.printValidParenthesis(5).size());
        System.out.println(sol.printValidParenthesis(6).size());
        System.out.println(sol.printValidParenthesis(7).size());
        System.out.println(sol.printValidParenthesis(8).size());
        System.out.println(sol.printValidParenthesis(9).size());
    }
}
