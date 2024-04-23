package crackingthecodinginterview.recursionanddynamicprogramming.question12;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueensProblemSolution {
    /**
     * Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
     */

    // Startingor row 0, place queen in valid positions starting from 0-N-1
    // When we place queen in all rows, we have a solution.



    public ArrayList<Integer[]> placeNQueens(int queensCount){
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] currentResult = new Integer[queensCount];
        Arrays.fill(currentResult, -1);
        placeNQueensHelper(0, currentResult, queensCount, results);
        return results;

    }

    private void placeNQueensHelper(int currentRow, Integer[] currentResult, int queensCount, ArrayList<Integer[]> results){
        if(currentRow == queensCount){
            results.add(currentResult.clone());
            return;
        }
        for(int currentCol=0; currentCol < queensCount; currentCol++){
            if(isValidQueenPosition(currentResult, currentRow, currentCol)){
                currentResult[currentRow]=currentCol;
                placeNQueensHelper(currentRow + 1, currentResult, queensCount, results);
                currentResult[currentRow]=-1;
            }
        }
    }

    private boolean isValidQueenPosition(Integer[] currentResult, int currentRow, int currentCol){
        for(int prevRow=0; prevRow<currentRow; prevRow++){
            int prevCol=currentResult[prevRow];
            if(prevCol == currentCol)
                return false;
            if(Math.abs(currentRow - prevRow) == Math.abs(currentCol - prevCol))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer[]> results = new NQueensProblemSolution().placeNQueens(8);
        for (Integer[] result : results) {
            System.out.println();
            for(int i=0; i< result.length; i++)
            System.out.print(result[i] + " ");
        }
    }
}
