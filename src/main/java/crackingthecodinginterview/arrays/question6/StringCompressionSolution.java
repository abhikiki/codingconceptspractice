package crackingthecodinginterview.arrays.question6;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3, If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompressionSolution {

    //Time Complexity: O(n) where n=length of given string
    //Space Complexity: O(1)
    public String  compression(String str) {
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException("Invalid input");
        char prev = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<str.length(); i++){
            if(prev == str.charAt(i)){
                count++;
            }else{
                sb.append(prev).append(count);
                prev = str.charAt(i);
                count=1;
            }
        }
        sb.append(prev).append(count);
        return sb.length() >= str.length() ? str : sb.toString();
    }

    public static void main(String[] args) {
        StringCompressionSolution sol = new StringCompressionSolution();
        System.out.println(sol.compression("Aa"));//A1a1 => Aa
        System.out.println(sol.compression("AAAAa"));//A4a1 => A4a1
        System.out.println(sol.compression("aabcccccaaa"));//a2b1c4a3 => a2b1c5a3
    }
}
