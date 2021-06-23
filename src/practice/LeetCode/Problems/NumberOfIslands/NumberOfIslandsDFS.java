package practice.LeetCode.Problems.NumberOfIslands;

/**
 * Created by srikar on 18-06-2021.
 */

class NumberOfIslandsDFS {
    // consider four directions: north, south, east, west
    private static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // number of islands that we have seen thus far
    private int islands;

    public int numIslands(char[][] grid) {
        islands = 0;

        // Search through the grid
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // If a bit of land is found expand upon it
                if(grid[row][col] == '1') {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // don't search for either marked landmarks or water
        if(grid[row][col] != '1') return;

        // mark this patch of land with a land mark
        grid[row][col] = '2';

        // explore all four directions
        for(int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];

            // if we are out of bounds ignore
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) continue;

            // explore
            dfs(grid, r, c);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
    }
}