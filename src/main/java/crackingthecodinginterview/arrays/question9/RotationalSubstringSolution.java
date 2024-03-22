package crackingthecodinginterview.arrays.question9;

/**
 String Rotation:Assume you have a method isSubstring which checks if one word is a substring of another.
 Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring
 (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
public class RotationalSubstringSolution {
    // waterbottlewaterbottle

    public boolean isRotationalSubstring(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() == 0 | str2.length() ==0){
            throw new IllegalArgumentException("Invalid input");
        }

        return (str1+str1).indexOf(str2) != -1; // or we can use the given isSubstring method if provided
    }



    public static void main(String[] args) {
        RotationalSubstringSolution sol = new RotationalSubstringSolution();
        System.out.println(sol.isRotationalSubstring("waterbottle", "erbottlewat")); //true
        System.out.println(sol.isRotationalSubstring("waterbottle", "erbotlewatt")); //false
    }
}
