package lc;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/9/16
 **/
public class N212WordSearch2 {
    private final TrieNode root = new TrieNode();
    private final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Set<String> set = new HashSet<>();
    private boolean[][] visited;
    int m;
    int n;

    static class TrieNode {
        String s;
        TrieNode[] children = new TrieNode[26];
    }

    public static void main(String[] args) {
        N212WordSearch2 demo = new N212WordSearch2();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> ans = demo.findWords(board, words);
        System.out.println(ans);
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (String str : words) insert(str);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j] - 'a';
                visited[i][j] = true;
                dfs(board, i, j, root.children[index]);
                visited[i][j] = false;
            }
        }
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (node == null) return;
        if (node.s != null) set.add(node.s);
        for (int[] d : dir) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visited[nx][ny]) continue;
            int index = board[nx][ny] - 'a';
            visited[nx][ny] = true;
            dfs(board, nx, ny, node.children[index]);
            visited[nx][ny] = false;
        }
    }

    private void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (p.children[index] == null) p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.s = s;
    }

}
