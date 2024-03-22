package crackingthecodinginterview.arrays.question7;

public class RotateMatrixSolution2 {

    //Time Complexity: O(n2) where n is length of the matrix
    //space Complexity: O(1)
    public int[][] rotateMatrix(int[][] m){
        if(m==null || m.length != m[0].length){
            throw new IllegalArgumentException("Input is not valid");
        }

        int n = m.length;
        for (int col = 0; col < n / 2; col++) {
            for (int row = 0; row < n/2 ; row++) {
                int temp = m[n-col-1][row];
                m[n-col-1][row] = m[n-row-1][n-col-1];
                m[n-row-1][n-col-1] = m[col][n-row-1];
                m[col][n-row-1] = m[row][col];
                m[row][col] = temp;
            }
        }
        return m;
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
                {11,12,13,14,15, 77},
                {17,18,19,20,21, 66},
                {22,23,24,25,26, 55},
                {88,11,22,33,44,55}
        };

        RotateMatrixSolution2 sol = new RotateMatrixSolution2();
        int[][] rotatedMatrix = sol.rotateMatrix(m); //90 degree
        sol.printMatrix(rotatedMatrix);
    }
}
