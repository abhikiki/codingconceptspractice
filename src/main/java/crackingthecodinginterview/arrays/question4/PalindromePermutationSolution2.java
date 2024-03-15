package crackingthecodinginterview.arrays.question4;

/**
 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters
 */
public class PalindromePermutationSolution2 {
    // aabaa atmost 1 character with count 1
    //Time Complexity: O(n) where n = length of given string
    //Space Complexity: O(1)
    public boolean isPalindromePermutation(String str) {
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException("Invalid input");
        int duplicateTracker = 0;
        for(char c: str.toCharArray()) {
            if(c == ' ')
                continue;
            char lowerCase = Character.toLowerCase(c);
            duplicateTracker = toggleBit(duplicateTracker, lowerCase);
        }
        return duplicateTracker == 0
               || (duplicateTracker & (duplicateTracker - 1)) == 0;
    }

    private int toggleBit(int tracker, char c){
        int index = 1 << c - 'a';
        if((tracker & index) == 0){ // means bit is 0 so we need to set it
            tracker |= index;
        } else { // means bit is 1 so we need to clear it
            tracker ^= index;
        }
        return tracker;
    }

    public static void main(String[] args) {
        PalindromePermutationSolution2 sol = new PalindromePermutationSolution2();
        System.out.println(sol.isPalindromePermutation("aabaa")); //true
        System.out.println(sol.isPalindromePermutation("abab")); //true
        System.out.println(sol.isPalindromePermutation("ab ab"));//true
        System.out.println(sol.isPalindromePermutation("abccab"));//true
        System.out.println(sol.isPalindromePermutation("Tact Coa"));//true
        System.out.println(sol.isPalindromePermutation("Tact Co"));//false
    }
}
