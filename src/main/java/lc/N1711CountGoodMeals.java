package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hawdies
 * @date 2021/7/7
 **/
public class N1711CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        final int MOD = (int) (1e9 + 7);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        for (int e : deliciousness) {
            maxVal = Math.max(maxVal, e);
        }
        int maxSum = 2 * maxVal;
        for (int i = 0; i < deliciousness.length; i++) {
            int val = deliciousness[i];
            for (int j = 1; j <= maxSum; j <<= 1) {
                int curCount = map.getOrDefault(j - val, 0);
                count = (count + curCount) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return count;
    }
}
