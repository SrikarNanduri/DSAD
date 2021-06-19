package practice.LeetCode.Problems.NumberOfIslands;

/**
 * Created by srikar on 18-06-2021.
 */

public class NumberOfIslands {
    // we will maintain a 2D array for visited cells
    int[][] visited;
    int count=0,n=0,m=0;

    public int numIslands(char[][] grid) {
        n = grid.length; m = grid[0].length;
        visited = new int[n][m];
        // we will traverse the grid if we find '1', then increment count
        //& use DFS traversal to make all adjacent '1' as visited
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    check(i,j,grid);
                }
            }
        }

        return count;
    }

    public void check(int r,int c, char[][] grid){

        visited[r][c]=1;
        if(r-1>=0 && visited[r-1][c]!=1 && grid[r-1][c]=='1')
            check(r-1,c,grid);
        if(r+1<n && visited[r+1][c]!=1 && grid[r+1][c]=='1')
            check(r+1,c,grid);
        if(c-1>=0 && visited[r][c-1]!=1 && grid[r][c-1]=='1')
            check(r,c-1,grid);
        if(c+1<m && visited[r][c+1]!=1 && grid[r][c+1]=='1')
            check(r,c+1,grid);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
    }
}
