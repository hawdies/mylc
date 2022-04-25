package lc;

import java.util.Random;

/**
 * @author hawdies
 * @date 2022/4/25
 */
public class N398RandomPickIndex {
    private int[] nums;

    public N398RandomPickIndex(int[] nums) {
        nums = nums;
    }

    public int pick(int target) {
        int cnt = 0;
        int idx = -1;
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
                if (rand.nextInt(cnt) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(1));
    }
}
