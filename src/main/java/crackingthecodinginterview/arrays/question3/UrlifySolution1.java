package crackingthecodinginterview.arrays.question3;

public class UrlifySolution1 {
    /**
     URLify (Write a method to replace all spaces in a string with '%20').
     You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
     (Note: if implementing in java, please use a character array so that you can perform this operation in place.)

     Time Complexity: O(str.length)
     Space Complexity: O(1)
     */
    public String urlify(char[] str, int trueLength) {
        if(str == null || str.length == 0 || trueLength > str.length)
            throw new IllegalArgumentException("Input is not valid");

        int spaceCount = countSpace(str, trueLength);
        int actualArrayLength = trueLength + spaceCount * 2;
        int startIndex = trueLength - 1;
        int endIndex = actualArrayLength - 1;
        while(startIndex >= 0) {
            if(str[startIndex] != ' '){
                str[endIndex--] = str[startIndex--];
            } else {
                str[endIndex--] = '0';
                str[endIndex--] = '2';
                str[endIndex--] = '%';
                startIndex--;
            }
        }
        return new String(str);
    }

    private int countSpace(char[] str, int trueLength) {
        int spaceCount = 0;
        for(int i=0; i<trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    public static void main(String[] args) {
        UrlifySolution1 sol = new UrlifySolution1();
        System.out.println(sol.urlify("a bc d    ".toCharArray(), 6)); //a%20bc%20d
        System.out.println(sol.urlify("   ".toCharArray(), 1));//%20
    }
}
