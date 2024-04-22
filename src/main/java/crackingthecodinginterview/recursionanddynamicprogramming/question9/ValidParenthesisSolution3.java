package crackingthecodinginterview.recursionanddynamicprogramming.question9;

import java.util.ArrayList;

public class ValidParenthesisSolution3 {
    public ArrayList<String> prinValidParenthesis(int n){
        ArrayList<String> results = new ArrayList<>();
        if(n <= 0)
            return results;
        prinValidParenthesisHelper("", n, n, results);
        return results;
    }

    private void prinValidParenthesisHelper(String current, int lRem, int rRem, ArrayList<String> results) {
        if(lRem < 0 || lRem > rRem) //invalid state
            return;
        if(lRem == 0 && rRem == 0){
            results.add(current);
            return;
        }
        prinValidParenthesisHelper(current + "(", lRem - 1, rRem, results);
        prinValidParenthesisHelper(current + ")", lRem, rRem - 1, results);
    }

    public static void main(String[] args) {
        ValidParenthesisSolution3 sol = new ValidParenthesisSolution3();
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
