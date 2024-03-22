package crackingthecodinginterview.arrays.question8;

import java.util.Arrays;

/**
 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrixSolution1 {
    // Time Complexity: O(M*N)
    // Space Comlpexity: O(1)
    public int[][] zeroMatrix(int[][] m) {
        if(m == null || m.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        boolean[] zeroRowTracker = new boolean[m.length];
        boolean[] zeroColTracker = new boolean[m[0].length];

        setZeroTracker(zeroRowTracker, zeroColTracker, m);
        for(int row=0; row<m.length; row++) {
            for(int col=0; col<m[0].length; col++) {
                if(zeroRowTracker[row] || zeroColTracker[col]){
                    m[row][col] = 0;
                }
            }
        }

        return m;
    }

    private void setZeroTracker(boolean[] zeroRowTracker, boolean[] zeroColTracker, int[][] m){
        for(int row=0; row<m.length; row++) {
            for(int col=0; col<m[0].length; col++) {
                if(m[row][col] == 0){
                    zeroRowTracker[row] = true;
                    zeroColTracker[col] = true;
                }
            }
        }
    }

    private void printMatrix(final int[][] m) {
        for (int row=0; row<m.length; row++) {
            for(int col=0; col<m[0].length; col++) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4, 5, 88},
                {6, 7,8,9,10, 99},
                {11,0,13,14,15, 77},
                {17,18,19,20,21, 66},
                {22,23,24,25,26, 55},
                {88,11,22,33,44,55}
        };

        ZeroMatrixSolution1 sol = new ZeroMatrixSolution1();
        int[][] rotatedMatrix = sol.zeroMatrix(m); //90 degree
        sol.printMatrix(rotatedMatrix);
    }
}
