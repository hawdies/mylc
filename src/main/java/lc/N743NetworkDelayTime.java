package lc;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/8/2
 **/
public class N743NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] adjusts = new int[n][n];
        for (int[] adjust : adjusts) {
            Arrays.fill(adjust, INF);
        }
        for (int[] time : times) {
            adjusts[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        boolean[] used = new boolean[n];
        dist[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (minIndex == -1 || dist[j] < dist[minIndex])) {
                    minIndex = j;
                }
            }
            used[minIndex] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[minIndex] + adjusts[minIndex][j]);
            }
        }
        int res = Arrays.stream(dist).max().getAsInt();
        return res == INF ? -1 : res;
    }
}
