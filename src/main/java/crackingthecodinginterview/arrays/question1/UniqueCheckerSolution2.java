package crackingthecodinginterview.arrays.question1;

public class UniqueCheckerSolution2 {

    // Assuming given string only contains alphabets
    // Time Complexity: O(n) where n = length of given string
    // Space Complexity: O(1) where n = length of given string
    public boolean containsUniqueCharacter(final String str){
        int upperCaseDuplicateTracker = 0;
        int lowerCaseDuplicateTracker = 0;
        int index = 0;
        for(char c : str.toCharArray()) {

            if(Character.isUpperCase(c)) {
                index = c - 'A';
                if ((upperCaseDuplicateTracker &= 1 << index) != 0) {
                    return false;
                }
                upperCaseDuplicateTracker |= 1 << index;
            } else {
                index = c - 'a';
                if ((lowerCaseDuplicateTracker &= 1 << index) != 0) {
                    return false;
                }
                lowerCaseDuplicateTracker |= 1 << index;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCheckerSolution1 sol = new UniqueCheckerSolution1();
        System.out.println("a=" + sol.containsUniqueCharacter("a")); //true
        System.out.println("aa=" + sol.containsUniqueCharacter("aa")); //false
        System.out.println("abcB=" + sol.containsUniqueCharacter("abcB"));//false
        System.out.println("abBca=" + sol.containsUniqueCharacter("abBca"));//false
    }
}
