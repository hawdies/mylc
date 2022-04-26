package lc;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2022/4/26
 */
public class N883ProjectionArea {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int area1 = 0;
        int area2 = 0;
        int area3 = 0;
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            int rowArea = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    area1++;
                    rowArea = Math.max(rowArea, grid[i][j]);
                    cols[j] = Math.max(cols[j], grid[i][j]);
                }
            }
            area2 += rowArea;
        }
        area3 = Arrays.stream(cols).sum();
        return area1 + area2 + area3;
    }
}
