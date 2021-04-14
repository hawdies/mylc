package others;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/4/14
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int l, int r) {
        if (l < r) {
            int mid = partition(array, l, r);
            sort(array, l, mid - 1);
            sort(array, mid + 1, r);
        }
    }

    private static int partition(int[] array, int l, int r) {
        int pivot = array[l];
        while (l < r) {
            while (l < r && array[r] >= pivot) r--;
            swap(array, l, r);
            while (l < r && array[l] <= pivot) l++;
            swap(array, r, l);
        }
        return l;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
