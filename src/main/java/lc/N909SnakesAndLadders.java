package lc;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * description: N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 * 玩家从棋盘上的方格1 （总是在最后一行、第一列）开始出发。
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1
 *
 * 思路: BFS,注意将二维数组转换为一维,要注意棋盘的顺序问题
 * @author hawdies
 * @date 2021/6/27
 **/
public class N909SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] src = new int[n * n + 1];
        int k = 1;
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            flag = !flag;
            for (int j = flag ? 0 : n -1; flag ? j < n : j >= 0; j += flag ? 1 : -1) {
                src[k++] = board[i][j];
            }
        }
        int res = dfs(src);
        return res;
    }

    private int dfs(int[] src) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.add(1);
        map.put(1, 0);
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int step = map.get(curIndex);
            if (curIndex == src.length - 1) return step;
            for (int i = 1; i <= 6; i++) {
                int nextIndex = curIndex + i;
                if (nextIndex >= src.length) break;
                if (src[nextIndex] != -1) nextIndex = src[nextIndex];
                if (map.containsKey(nextIndex)) continue;
                if (nextIndex < src.length) {
                    queue.add(nextIndex);
                    map.put(nextIndex, step + 1);
                }
            }
        }
        return -1;
    }
}
