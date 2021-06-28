package lc;

/**
 * 非降数组,旋转后查找否存在某个元素
 * 思路: 如果nums[left] == nums[mid] 无法判断千般序列有序还是后半序列有序,只能left++
 * 判断target不仅要和num[mid]比较,也要和相应的nums[left]或者nums[right]比较
 *
 * @author hawdies
 * @date 2021/4/11
 **/
public class N81SearchInRoatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) left++;
            else if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;

            } else {
                if (target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
