package dynamicprogramming.robotpath;

/**
 * Created by rishugupta on 7/23/17.
 */
public class RobotPath {

    /**
     * Time: O(2^n)
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int countPaths(boolean[][] grid, int row, int col) {
        if(!isValidSquare(grid, row, col)) {
            return 0;
        }
        if(isAtEnd(grid, row, col)) {
            return 1;
        }
        return countPaths(grid, row+1, col) + countPaths(grid, col+1, row);
    }

    public boolean isValidSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    public boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == grid.length - 1 && col == grid.length - 1;
    }
}
