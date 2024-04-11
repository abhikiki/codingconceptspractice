package crackingthecodinginterview.recursionanddynamicprogramming.question6;

import java.util.Stack;

public class TowersOfHanoiSolution {
    char from = 'A';
    char aux = 'B';
    char to = 'C';

    public void towerOfHanoi(int n, char from, char to, char aux){
        if(n == 1){
            System.out.println("Move disk=" + n + " from=" + from + " to=" + to);
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Move disk=" + (n) + " from=" + from + " to=" + to);
        towerOfHanoi(n-1, aux, to, from);
    }

    public static void main(String[] args) {
        new TowersOfHanoiSolution().towerOfHanoi(4, 'A', 'C', 'B');
    }

}
