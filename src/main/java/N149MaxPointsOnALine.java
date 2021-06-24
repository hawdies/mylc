import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/6/24
 **/
public class N149MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int[] p0 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[j];
                int cnt = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] p2 = points[k];

                    int k1 = (p1[1] - p0[1]) * (p2[0] - p1[0]);
                    int k2 = (p2[1] - p1[1]) * (p1[0] - p0[0]);
                    if (k1 == k2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
