package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @Date 2021/3/22
 **/
public class N079WordSearch {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Character> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = backtrack(board, word, i, j, 0, list, visited);
                    if (flag) {
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index, List<Character> list, boolean[][] visited) {
        // 两个if的先后顺序很重要
        if (index >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        boolean flag = false;
        if (!visited[row][col] && board[row][col] == word.charAt(index)) {
            list.add(board[row][col]);
            visited[row][col] = true;
            flag = backtrack(board, word, row - 1, col, index + 1, list, visited)
                    || backtrack(board, word, row + 1, col, index + 1, list, visited)
                    || backtrack(board, word, row, col - 1, index + 1, list, visited)
                    || backtrack(board, word, row, col + 1, index + 1, list, visited);
            list.remove(list.size() - 1);
            visited[row][col] = false;
        }
        return flag;
    }
}
