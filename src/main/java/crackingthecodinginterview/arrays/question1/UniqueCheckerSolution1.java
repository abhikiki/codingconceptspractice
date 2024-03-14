package crackingthecodinginterview.arrays.question1;

import java.util.HashSet;

public class UniqueCheckerSolution1 {

    // Time Complexity: O(n) where n = length of given string
    // Space Complexity: O(n) where n = length of given string
    public boolean containsUniqueCharacter(final String str){
        if(str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        HashSet<Character> hset = new HashSet<>();
        for(char c : str.toCharArray()) {
            if(hset.contains(c)) {
                return false;
            } else {
                hset.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCheckerSolution1 sol = new UniqueCheckerSolution1();
        System.out.println("a=" + sol.containsUniqueCharacter("a")); //true
        System.out.println("aa=" + sol.containsUniqueCharacter("aa")); //false
        System.out.println("abc=" + sol.containsUniqueCharacter("abc"));//true
        System.out.println("abbca=" + sol.containsUniqueCharacter("abbca"));//false
    }
}
