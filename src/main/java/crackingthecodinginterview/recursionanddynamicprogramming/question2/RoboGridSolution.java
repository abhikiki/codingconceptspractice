package crackingthecodinginterview.recursionanddynamicprogramming.question2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

class Cell {

    int row;
    int col;

    Cell() {
    }

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object that){
        if(this == that)
            return true;
        if(that == null)
            return false;
        if(!(that instanceof Cell))
            return false;
        Cell thatCell = (Cell)that;
        return this.row == thatCell.row && this.col == thatCell.col;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.row, this.col);
    }

    @Override
    public String toString(){
        return "(" + row + ", " + col + ")";
    }
}
public class RoboGridSolution {
    // Time Complexity: O(2^(|row| + |col|)).
    // Inorder to reduce time complexity to O(|row|*|col|) we need to use memonization.
    // Store failedPoints
    // Space Complexity: O(|row| * |col|))
    ArrayList<LinkedList<Cell>> findPath(boolean[][] grid){
        ArrayList<LinkedList<Cell>> results = new ArrayList<>();
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            results.add(new LinkedList<>());
            return results;
        }
        //dfs
        Cell start = new Cell(0,0);
        Cell end = new Cell(grid.length - 1, grid[0].length - 1);
        LinkedList<Cell> currentPath = new LinkedList<>();
        findPath(grid,start, end, results, currentPath);
        return results;
    }

    private void findPath(boolean[][] grid, Cell currentCell, Cell end, ArrayList<LinkedList<Cell>> results, LinkedList<Cell> currentPath){
        if(!isCellValid(grid, currentCell)){
            return;
        }
        currentPath.addLast(currentCell);
        if(currentCell.equals(end)){
            results.add((LinkedList<Cell>)currentPath.clone());
            return;
        }

        findPath(grid,new Cell(currentCell.row + 1, currentCell.col), end, results, currentPath);
        findPath(grid,new Cell(currentCell.row, currentCell.col + 1), end, results, currentPath);
        currentPath.removeLast();
    }

    public boolean isCellValid(boolean[][] grid, Cell cell){
        return cell.row >=0 && cell.row < grid.length
               && cell.col >= 0 && cell.col < grid[0].length
               && grid[cell.row][cell.col];
    }


    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{
                {true,false,false,false,false},
                {true,true,true,false,false},
                {false,false,true,true,false},
                {false,false,false,true,true}
        };

        ArrayList<LinkedList<Cell>> results = new RoboGridSolution().findPath(grid);
        System.out.println(results.size());
        System.out.println(results.get(0));
    }
}
