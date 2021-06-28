package lc;

/**
 * @author hawdies
 * @Date 2021/3/25
 **/
public class N200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || row >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
    }
}
