package dynamicprogramming.robotpath;

/**
 * Created by rishugupta on 7/25/17.
 */
public class RobitPathDynamicProgramming {


    /**
     * Time: O(n^2)
     *
     * @param grid
     * @param row
     * @param col
     * @param paths
     * @return
     */
    public int countPathDP(boolean[][] grid, int row, int col, int[][] paths) {
        if(!isValidSquare(grid, row, col)) {
            return 0;
        }
        if(isAtEnd(grid, row, col)) {
            return 1;
        }
        if(paths[row][col] == 0) {
            paths[row][col] = countPathDP(grid, row+1, col, paths) + countPathDP(grid, col+1, row, paths);
        }
        return paths[row][col];
    }

    public boolean isValidSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    public boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == grid.length - 1 && col == grid.length - 1;
    }
}
