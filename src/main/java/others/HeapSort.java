package others;

import java.util.Arrays;

/**
 * @author hawdies
 * @Date 2021/3/10
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 2, 1, 6};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void heapSort(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, j, 0);
            adjustHeap(nums, 0, j);
        }
    }

    private static void adjustHeap(int[] nums, int index, int length) {
        int temp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) i++;
            if (nums[i] > temp) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
