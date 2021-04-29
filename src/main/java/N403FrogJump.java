import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hawdies
 * @date 2021/4/29
 **/
public class N403FrogJump {
    private final Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        N403FrogJump n403FrogJump = new N403FrogJump();
        boolean b = n403FrogJump.canCross(stones);
        System.out.println(b);
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        return dfs(0, 0, stones, n);
    }

    private boolean dfs(int cur, int k, int[] stones, int n) {
        String key = cur + "-" + k;
        if (set.contains(key)) return false;
        set.add(key);
        if (cur == n - 1) return true;
        for (int i = cur + 1; i < n; i++) {
            int gap = stones[i] - stones[cur];
            if (gap > k + 1) break;
            if (gap < k - 1) continue;
            if (dfs(i, gap, stones, n)) return true;

        }
        return false;
    }
}
