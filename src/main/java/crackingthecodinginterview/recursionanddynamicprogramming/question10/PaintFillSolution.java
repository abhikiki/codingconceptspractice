package crackingthecodinginterview.recursionanddynamicprogramming.question10;

class Point{
    int row;
    int col;

    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

enum Color{
    RED, BLUE, BLACK;
}
public class PaintFillSolution {
    // Time Complexity: O(M*N) we need to traverse whole matrix
    // Space Complexity: O(M*N)
    public void paintFill(Color[][] matrix, Point point, Color newColor){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("Matrix input is invalid");
        if(point.row < 0 || point.col < 0 || point.row >= matrix.length || point.col >= matrix[0].length)
            throw new IllegalArgumentException("Input point is invalid");
        paintFillHelper(matrix, point, matrix[point.row][point.col], newColor);
    }

    private void paintFillHelper(Color[][] matrix, Point point, Color orgColor, Color newColor){
        if(point.row < 0 || point.col < 0 || point.row >= matrix.length || point.col >= matrix[0].length)
            return;
        if(matrix[point.row][point.col] == newColor)
            return;
        if(matrix[point.row][point.col] == orgColor){
            matrix[point.row][point.col] = newColor;
            paintFillHelper(matrix, new Point(point.row + 1, point.col), orgColor, newColor);
            paintFillHelper(matrix, new Point(point.row - 1, point.col), orgColor,newColor);
            paintFillHelper(matrix, new Point(point.row, point.col + 1), orgColor,newColor);
            paintFillHelper(matrix, new Point(point.row, point.col - 1), orgColor,newColor);
        }
    }

    public static void main(String[] args) {
        Color[][] matrix = {
                {Color.BLUE, Color.RED, Color.BLACK},
                {Color.RED, Color.RED, Color.RED},
                {Color.RED, Color.RED, Color.BLUE}
        };
        new PaintFillSolution().paintFill(matrix, new Point(0, 1), Color.BLUE);
        for(int row=0; row < matrix.length; row++){
            System.out.println("");
            for(int col=0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
        }

    }
}
