package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2022/4/27
 */
public class N417PacificAtlanticWaterFlow {
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // pacific
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }
        // atlantic
        for (int i = m - 1; i >= 0; i--) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = n - 1; j >= 0; j--) {
            dfs(m - 1, j, atlantic);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    list.add(cell);
                }
            }
        }
        return list;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && this.heights[newRow][newCol] >= this.heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
