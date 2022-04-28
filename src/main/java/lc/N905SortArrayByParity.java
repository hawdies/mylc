package lc;

/**
 * @author hawdies
 * @date 2022/4/28
 */
public class N905SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 0) i++;
            swap(i, j, nums);
            while (i < j && nums[j] % 2 == 1) j--;
            swap(i, j, nums);
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
