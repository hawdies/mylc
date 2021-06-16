import java.util.Arrays;

/**
 * description: 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * 思路1: 回溯法求解, 超时
 * 思路2: 动态规划
 * @author hawdies
 * @date 2021/6/16
 **/
public class N877StoneGame {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        N877StoneGame game = new N877StoneGame();
        boolean b = game.stoneGame2(piles);
        System.out.println(b);
    }

    private boolean flag;


    // 回溯求解
    public boolean stoneGame(int[] piles) {
        int sum = Arrays.stream(piles).sum();
        backtrack(piles, sum, 0, 0, 0, piles.length - 1);
        return flag;
    }

    private void backtrack(int[] piles, int sum, int value, int dept, int left, int right) {
        if (dept == piles.length / 2) {
            if (sum < 2 * value) {
                flag = true;
                return;
            }
        }
        if (left < 0 || right > piles.length - 1 || left > right) return;
        if (!flag) {
            backtrack(piles, sum, value + piles[left], dept + 1, left + 1, right - 1);
            backtrack(piles, sum, value + piles[left], dept + 1, left + 2, right);
            backtrack(piles, sum, value + piles[right], dept + 1, left + 1, right - 1);
            backtrack(piles, sum, value + piles[right], dept + 1, left, right - 2);
        }
    }

    // dp求解
    public boolean stoneGame2(int[] piles) {
        int n = piles.length / 2;
        int[] dp = new int[n + 1];
        for (int i = 0; i < piles.length; i += 2) {
            dp[i / 2 + 1] = Math.max(piles[i], piles[i + 1]) + dp[i / 2];
        }
        int sum = Arrays.stream(piles).sum();
        return sum < 2 * dp[n];
    }
}
