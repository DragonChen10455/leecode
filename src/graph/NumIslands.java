package graph;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i , j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j){
        if(!isValid(grid, i, j)) return;
        if(grid[i][j] == '1'){
            grid[i][j] = 2;
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
    }

    public boolean isValid(char[][] grid, int i, int j){
        return i > 0 && i < grid.length && j > 0 && j < grid[0].length;
    }
}
