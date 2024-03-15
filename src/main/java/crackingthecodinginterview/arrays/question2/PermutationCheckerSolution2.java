package crackingthecodinginterview.arrays.question2;

public class PermutationCheckerSolution2 {
    int duplicateTrackerLowercase = 0;
    int duplicateTrackerUppercase = 0;

    /**
     Given two strings, write a method to determine if one is permutation of the other.
     Assumption: String only contains Alphabets

     Time Complexity: O(n1 + n2) sum of length of both strings
     Space Complexity: O(2) or say O(1) constant time
     */
    public boolean isPermutation(final String str1, final String str2) {
        if(str1 == null || str2 == null)
            throw new IllegalArgumentException("Invalid input");
        if(str1.length() != str2.length())
            return false;
        updateDuplicateTracker(str1);
        updateDuplicateTracker(str2);

        return duplicateTrackerLowercase == 0 && duplicateTrackerUppercase == 0;
    }

    private void updateDuplicateTracker(final String str) {
        for(char c: str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                duplicateTrackerLowercase = toggleBit(duplicateTrackerLowercase, c - 'a');
            } else {
                duplicateTrackerUppercase = toggleBit(duplicateTrackerUppercase, c - 'A');
            }
        }
    }

    private  int toggleBit(int duplicateTracker, final int index) {
        int pattern = 1 << index;
        if((duplicateTracker & pattern) == 0){ //implies not set
            duplicateTracker |= pattern;
        } else{
            duplicateTracker ^= pattern; // set bit
        }
        return duplicateTracker;
    }

    public static void main(String[] args) {
        PermutationCheckerSolution2 sol = new PermutationCheckerSolution2();
        System.out.println(sol.isPermutation("a", "ab")); //false
        System.out.println(sol.isPermutation("ab", "a")); //false
        System.out.println(sol.isPermutation("aba", "baa")); //true
        System.out.println(sol.isPermutation("acb", "def")); //false
    }
}
