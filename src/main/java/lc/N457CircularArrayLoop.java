package lc;

/**
 * description: 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 *
 * 思路: 使用双指针判断环
 * @author hawdies
 * @date 2021/8/7
 **/
public class N457CircularArrayLoop {
    public static void main(String[] args) {
        N457CircularArrayLoop demo = new N457CircularArrayLoop();
        int[] nums = {-1, 2};
        boolean b = demo.circularArrayLoop(nums);
        System.out.println(b);
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int slow = i;
            int fast = next(nums, i);
            while (!visited[slow] && !visited[fast] && !visited[next(nums,fast)]
                    && nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int k = i;
            while (!visited[k] && nums[k] * nums[next(nums, k)] > 0) {
                visited[k] = true;
                k = next(nums, k);
            }
        }
        return false;
    }

    private int next(int[] nums, int curr) {
        int n = nums.length;
        // 避免这种情况: -1 % 2 = -1, 故需要 + n
        return ((curr + nums[curr]) % n + n) % n;
    }
}
