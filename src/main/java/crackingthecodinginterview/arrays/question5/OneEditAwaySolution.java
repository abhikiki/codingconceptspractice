package crackingthecodinginterview.arrays.question5;

/**
 One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a
 test est   (test,est)
 test testx (test,testx)
 test best  (test,best)
 ""   t empty. (t,"")

 add and remove can be replaced with just add if we fix one string in terms caller passing bigger string as first argument
 */
public class OneEditAwaySolution {
    //O(n + 1) = O(n) where length of smaller string


    public boolean isOneAway(String biggerStr, String smallerStr) {
        if(biggerStr == null || smallerStr == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if(biggerStr.length() == 0 && smallerStr.length() == 0)
            return true;
        if (biggerStr.length() < smallerStr.length())
            return isOneAway(smallerStr, biggerStr);

        int index1 = 0;
        int index2 = 0;

        boolean editDone = false;
        while((index1 < biggerStr.length()) && (index2 < smallerStr.length())) {
            if(biggerStr.charAt(index1) == smallerStr.charAt(index2)) {
                index1++;
                index2++;
            } else if(!editDone){
                editDone = true;
                if(biggerStr.length() == smallerStr.length())
                    index2++;
                index1++;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneEditAwaySolution sol = new OneEditAwaySolution();
        System.out.println(sol.isOneAway("pale", "ple"));
        System.out.println(sol.isOneAway("pales", "pale"));
        System.out.println(sol.isOneAway("pale", "bale"));
        System.out.println(sol.isOneAway("pale", "bake"));
        System.out.println(sol.isOneAway("p", ""));
        System.out.println(sol.isOneAway("", ""));
        System.out.println(sol.isOneAway("a", "bc"));
        System.out.println(sol.isOneAway("a", "ac"));
    }
}
