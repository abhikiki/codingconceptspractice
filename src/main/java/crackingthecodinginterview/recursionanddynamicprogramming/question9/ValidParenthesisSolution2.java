package crackingthecodinginterview.recursionanddynamicprogramming.question9;

import java.util.ArrayList;

public class ValidParenthesisSolution2 {

    public ArrayList<String> prinValidParenthesis(int n){
        ArrayList<String> results = new ArrayList<>();
        if(n <= 0)
            return results;
        prinValidParenthesisHelper(new char[n *2], n, n, results, 0);
        return results;
    }

    private void prinValidParenthesisHelper(char[] current, int lRem, int rRem, ArrayList<String> results, int index) {
        if(lRem < 0 || lRem > rRem) //invalid state
            return;
        if(lRem == 0 && rRem == 0){
            results.add(String.copyValueOf(current));
            return;
        }
        current[index] = '(';
        prinValidParenthesisHelper(current, lRem - 1, rRem, results, index + 1);
        current[index] = ')';
        prinValidParenthesisHelper(current, lRem, rRem - 1, results, index + 1);
    }

    public static void main(String[] args) {
        ValidParenthesisSolution2 sol = new ValidParenthesisSolution2();
        System.out.println(sol.prinValidParenthesis(1).size());
        System.out.println(sol.prinValidParenthesis(2).size());
        System.out.println(sol.prinValidParenthesis(3));
        System.out.println(sol.prinValidParenthesis(4).size());
        System.out.println(sol.prinValidParenthesis(5).size());
        System.out.println(sol.prinValidParenthesis(6).size());
        System.out.println(sol.prinValidParenthesis(7).size());
        System.out.println(sol.prinValidParenthesis(8).size());
        System.out.println(sol.prinValidParenthesis(9).size());
    }
}
