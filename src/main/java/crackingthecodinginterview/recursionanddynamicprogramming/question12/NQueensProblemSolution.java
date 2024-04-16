package crackingthecodinginterview.recursionanddynamicprogramming.question12;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueensProblemSolution {

    public ArrayList<Integer[]> placeNQueens(int n){
        return placeNQueens(n,n);
    }

    // n queens, n*n grid
    public ArrayList<Integer[]> placeNQueens(int n, int gridSize){
        if(n < 0){
            ArrayList<Integer[]> result = new ArrayList<>();
            Integer[] emptyResult = new Integer[gridSize];
            result.add(emptyResult);
            return result;
        }
        ArrayList<Integer[]> finalResult = new ArrayList<>();
        ArrayList<Integer[]> prevResult = placeNQueens(n - 1, gridSize);
        for(Integer[] currentRow : prevResult){
            Integer[] currentResult = placeCurrentQueen(currentRow, n);
            finalResult.add(currentResult);

        }
        return finalResult;
    }

    //arr[r0] = 3
    //arr[r1] = 2
    //arr[r2] = 0
    //arr[r3] = 1
    private Integer[] placeCurrentQueen(Integer[] rowColResult, int currentQueen){
        //currentCol
        //currentRow
        //queenROw
        //queenCol
        int queenRow = currentQueen - 1;
        for(int row=0; row < rowColResult.length; row++){
            Integer currentCol = rowColResult[row];
            if(currentCol != null){
                for(int col=0; col < currentCol; col++){
                    if(currentCol == col){
                        continue;
                    }
                    if(Math.abs(currentCol - col) == Math.abs(row - queenRow)){
                        continue;
                    }
                    rowColResult[row] = col;
                    break;
                }
            }
        }

        return rowColResult;
    }


    public static void main(String[] args) {
        ArrayList<Integer[]> results = new NQueensProblemSolution().placeNQueens(4);
        for(Integer[] result : results){
            for(Integer r : result){
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
