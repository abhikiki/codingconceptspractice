package crackingthecodinginterview.recursionanddynamicprogramming.question7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationWithoutDuplicatesSolution {

    int count = 0;
    public HashSet<String> permutationWithoutDuplicates(String str){
        if(str == null || str.length() == 0){
            return new HashSet<>();
        }
        HashSet<String> results = new HashSet<>();
        permutationWithoutDuplicatesHelper(str, "", results);
        return results;
    }

    //Space Complexity: O(N) where N=length of the given string
    //Time Complexity: N * N!    //4 * (2 * 3) 4 * (n-1)!) = 4 * 3 * 2 * 4  $ 4 * 16
    // 4 = 64  n * (n-1)! = 5* 4! = 5 * 4.3.2 =
    // 5 = 325 5.4.3.2= 60 * 5 = 300
    private void permutationWithoutDuplicatesHelper(String str, String prefix, HashSet<String> results) {
        System.out.println(count++);
        if(str.length() == 0){
            results.add(prefix);
            return;
        }

        for(int i=0; i< str.length(); i++){
            char currentChar = str.charAt(i);
            permutationWithoutDuplicatesHelper(str.substring(0,i ) + str.substring(i+1), currentChar + prefix, results);
        }
    }

    public static void main(String[] args) {
        PermutationWithoutDuplicatesSolution sol = new PermutationWithoutDuplicatesSolution();
        System.out.println(sol.permutationWithoutDuplicates("abhis"));
    }
}
