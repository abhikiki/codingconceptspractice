package crackingthecodinginterview.arrays.question7;

public class RotateMatrixSolution1 {
    //   1   2   3   4   5
    //   6   7   8   9   10
    //   11. 12  13  14  15
    //   16  17  18  19  20
    //   21  22  23  24  25

    // Transpose
    //   1   6   11  16  21
    //   2   7   12  17  22
    //   3   8   13  18  23
    //   4   9   14  19  24
    //   5   10  15  20  25
    //   then swap elemnts along the column

    // Result
    //   21  16  11  6   1
    //   22  17  12  7   2
    //   23  18  13  8   3
    //   24  19  14  9   4
    //   25  20  15  10  5

    //Time Complexity: O(n2) where n is length of the matrix
    //space Complexity: O(1)
    public int[][] rotateMatrix(int[][] m){
        if(m==null || m.length != m[0].length){
            throw new IllegalArgumentException("Input is not valid");
        }
        m = tranpose(m);
        m = mirrorImage(m);
        return m;
    }

    private int[][] tranpose(int[][] m) {
        for(int row=0; row<m.length; row++){
            for(int col=0; col<m[0].length; col++) {
                if(row < col) {
                    int temp = m[row][col];
                    m[row][col] = m[col][row];
                    m[col][row] = temp;
                }
            }
        }
        return m;
    }

    private int[][] mirrorImage(int[][] m){
        for(int row=0; row<m.length; row++){
            for(int col=0; col<m[0].length/2; col++) {
                int temp = m[row][col];
                m[row][col] = m[row][m[0].length - 1 - col];
                m[row][m[0].length - 1 - col] = temp;
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

        RotateMatrixSolution1 sol = new RotateMatrixSolution1();
        int[][] rotatedMatrix = sol.rotateMatrix(m); //90 degree
        sol.printMatrix(rotatedMatrix);
    }
}
