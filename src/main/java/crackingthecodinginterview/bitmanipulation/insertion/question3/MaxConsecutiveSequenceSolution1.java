package crackingthecodinginterview.bitmanipulation.insertion.question3;

public class MaxConsecutiveSequenceSolution1 {

    // Time Complexity: O(B) where B is the no. of bits
    public int findMaxConsecutiveSequence(int num){

        // 0000 0
        // 0001 1
        // 0101 5
        // 0110 6
        // 010011 18
        // 0101010 42
        // 010101 21
        // 001101 13
        // 11110011 243
        // 00111 7

        if(num == -1)
            return Integer.BYTES * 8;
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;
        while(num != 0){
            int currentBit = num & 1;
            if(currentBit == 1){
                currentLength++;
            }else{
                previousLength = (num & 2) == 0 ? 0: currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            num = num >>> 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(13));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(42));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(21));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(18));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(0));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(1));
        System.out.println(new MaxConsecutiveSequenceSolution1().findMaxConsecutiveSequence(243));
    }
}
