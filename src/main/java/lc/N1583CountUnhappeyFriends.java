package lc;

/**
 * description: 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 * x 与 u 的亲近程度胜过 x 与 y，且
 * u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 *
 * 思路:
 * 使用模拟法求解,需要两个辅助数组.orders[i][j]表示j在i中的索引下标, match[i]表示与i匹配的朋友.
 *
 * 对于x,y只要找出一对u,v; 使得(orders[x][u] < orders[x][y] && orders[u][x] < orders[u][v]),即x为不开心.
 *
 * @author hawdies
 * @date 2021/8/14
 **/
public class N1583CountUnhappeyFriends {
    public static void main(String[] args) {
        int[][] preference = {
                {1, 3, 2},
                {2, 3, 0},
                {1, 3, 0},
                {0, 2, 1}
        };
        int[][] pairs = {
                {1, 3},
                {0, 2}
        };
        N1583CountUnhappeyFriends demo = new N1583CountUnhappeyFriends();
        int i = demo.unhappyFriends(4, preference, pairs);
        System.out.println(i);
    }
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int count = 0;
        // orders[i][j]表示 j 在 i中索引的下标
        int[][] orders = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j <preferences[0].length; j++) {
                orders[i][preferences[i][j]] = j;
            }
        }

        int[] match = new int[n];
        for (int[] pair : pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }

        for (int[] pair : pairs) {
            if (unhappy(pair[0], pair[1], orders, preferences, match)) {
                count++;
            }
            if (unhappy(pair[1], pair[0], orders, preferences, match)) {
                count++;
            }
        }
        return count;
    }

    private boolean unhappy(int x, int y, int[][] orders, int[][] preferences, int[] match) {
        int end = orders[x][y];
        for (int i = 0; i < end; i++) {
            int u = preferences[x][i];
            int v = match[u];
            if (orders[x][u] < orders[x][y] && orders[u][x] < orders[u][v]) {
                return true;
            }
        }
        return false;
    }
}
