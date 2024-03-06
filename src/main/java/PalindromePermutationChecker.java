import java.util.HashMap;

public class PalindromePermutationChecker {

    // Ignore casing and space
    //O(str.length)
    public boolean isPalindromePermutation(final String str) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char c: str.toCharArray()) {
            if(c == ' ') {
                continue;
            }
            c = Character.toLowerCase(c);
            if(hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) - 1);
            } else {
                hmap.put(c, 1);
            }
        }
        return !(hmap.values().stream().filter(v -> v !=0 || v % 2 !=0).count() > 1);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("tact coa"));
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("atco cta"));
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("a a"));
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("aaa"));
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("aaab"));
        System.out.println(new PalindromePermutationChecker().isPalindromePermutation("abbba"));
    }

}
