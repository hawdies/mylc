/**
 * @author hawdies
 * @date 2021/5/8
 **/
public class N1723FindMinTimeToFinishAllJobs {

    public static void main(String[] args) {
        int[] jobs = {11,2,20,18,2,1,7,11,7,10};
        int k = 9;
        N1723FindMinTimeToFinishAllJobs n1723FindMinTimeToFinishAllJobs = new N1723FindMinTimeToFinishAllJobs();
        int i = n1723FindMinTimeToFinishAllJobs.minimumTimeRequired(jobs, k);
        System.out.println(i);
        System.out.println(n1723FindMinTimeToFinishAllJobs.count);
    }

    private int ans = Integer.MAX_VALUE / 2;
    int count = 1;

    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sums = new int[n];
        System.out.println("0=====0");
        dfs(0, 0, n, sums, k, 0, jobs);
        return ans;
    }

    private void dfs(int curr, int used, int n, int[] sums, int k, int max, int[] jobs) {
        if (max > ans) return;
        if (curr == n) {
            ans = max;
            return;
        }
        if (used < k) {
            sums[used] = jobs[curr];
            System.out.printf("%d ====== %d\n", curr + 1,used + 1);
            count++;
            dfs(curr + 1, used + 1, n, sums, k, Math.max(sums[used], max), jobs);
            sums[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sums[i] += jobs[curr];
            System.out.printf("%d ====== %d\n", curr + 1,used);
            count++;
            dfs(curr + 1, used, n, sums, k, Math.max(sums[i], max), jobs);
            sums[i] -= jobs[curr];
        }
    }
}
