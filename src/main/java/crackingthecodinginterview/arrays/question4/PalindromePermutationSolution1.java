package crackingthecodinginterview.arrays.question4;

import java.util.HashMap;

/**
 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters
 */
public class PalindromePermutationSolution1 {
    // aabaa atmost 1 character with odd count
    //Time Complexity: O(n) where n = length of given string
    //Space Complexity: O(n) where n = length of given string
    public boolean isPalindromePermutation(String str) {
        if(str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c : str.toCharArray()) {
            if(c == ' ')
                continue;
            char lowercase = Character.toLowerCase(c);
            if(hmap.containsKey(lowercase))
                hmap.put(lowercase, 0);
            else
                hmap.put(lowercase, 1);
        }
        return hmap.values().stream().filter(v -> v !=0).count() <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutationSolution1 sol = new PalindromePermutationSolution1();
        System.out.println(sol.isPalindromePermutation("aabaa"));
        System.out.println(sol.isPalindromePermutation("abab"));
        System.out.println(sol.isPalindromePermutation("ab ab"));
        System.out.println(sol.isPalindromePermutation("abccab"));
        System.out.println(sol.isPalindromePermutation("Tact Coa"));
        System.out.println(sol.isPalindromePermutation("Tact Co"));
    }
}
