package crackingthecodinginterview.bitmanipulation.insertion.question2;

public class BinaryToStringSolution {

    public String printBinaryRepresentation(double number){
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            double mult = number * 2;
            if(mult >= 1){
                sb.append("1");
                number = mult - 1;
            }else{
                sb.append("0");
                number = mult;
            }
            if(sb.length() >= 32){
                return "ERROR";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryToStringSolution sol = new BinaryToStringSolution();
        System.out.println(sol.printBinaryRepresentation(0.72));
        System.out.println(sol.printBinaryRepresentation(0.5));
        System.out.println(sol.printBinaryRepresentation(0.25));
    }
}
