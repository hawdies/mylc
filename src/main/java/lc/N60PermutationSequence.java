package lc;

/**
 * @author hawdies
 * @date 2021/4/29
 **/
public class N60PermutationSequence {
    public static void main(String[] args) {
        N60PermutationSequence n60PermutationSequence = new N60PermutationSequence();
        String s = n60PermutationSequence.getPermutation(4, 9);
        System.out.println(s);
    }

    private int k = 0;
    static int[] factorial = new int[10];
    static {
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public String getPermutation(int n, int k) {
        this.k = k;
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        dfs(sb, visited, 0, n);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, boolean[] visited, int cur, int n) {
        if (cur == n) return;
        int cnt = factorial[n  - cur - 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (cnt < k) {
                    k -= cnt;
                } else {
                    sb.append((char)('0' + i));
                    visited[i] = true;
                    dfs(sb, visited, cur + 1, n);
                    return;
                }
            }
        }
    }

}
