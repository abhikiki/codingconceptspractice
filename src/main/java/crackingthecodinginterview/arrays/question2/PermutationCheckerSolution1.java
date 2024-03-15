package crackingthecodinginterview.arrays.question2;

import java.util.HashSet;

public class PermutationCheckerSolution1 {

    // Time Complexity: O(n1 + n2) where
    //      n1 = length of string 1
    //      n2 = length of string 2
    // Space Complexity: O(n1 + n2)
    public boolean isPermutation(final String str1, final String str2) {
        if(str1 == null || str2== null || str1.length() != str2.length())
            return false;

        HashSet<Character> hset = new HashSet<>();
        toggleCharacterSet(hset, str1);
        toggleCharacterSet(hset, str2);

        return hset.isEmpty();
    }

    private void toggleCharacterSet(final HashSet<Character> hset, final String str) {
        for(char c : str.toCharArray()) {
            if(hset.contains(c)) {
                hset.remove(c);
            } else {
                hset.add(c);
            }
        }
    }
    public static void main(String[] args) {
        PermutationCheckerSolution1 sol = new PermutationCheckerSolution1();
        System.out.println(sol.isPermutation("a", "ab")); //false
        System.out.println(sol.isPermutation("ab", "a")); //false
        System.out.println(sol.isPermutation("aba", "baa")); //true
        System.out.println(sol.isPermutation("acb", "def")); //false
    }
}
