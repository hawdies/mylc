package others;

import java.util.Arrays;

/**
 * 快排,归并,堆排的实现
 *
 * @author hawdies
 * @date 2021/5/8
 **/
public class AllSorts {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 1, 53, 4, 5, 5, 7, 2, 10, 102};
        AllSorts allSorts = new AllSorts();
        allSorts.heapsort(array);
        System.out.println(Arrays.toString(array));
    }

    public void quicksort(int[] array) {
        quicksort0(array, 0, array.length);
    }

    // [l, r) 左闭右开
    private void quicksort0(int[] array, int l, int r) {
        int right = r - 1;
        if (l < right) {
            int mid = findIndex(array, l, r);
            if (mid > 0) quicksort0(array, l, mid);
            if (mid < right) quicksort0(array, mid + 1, r);
        }
    }

    private int findIndex(int[] array, int l, int r) {
        int pivot = array[l];
        int right = r - 1;
        while (l < right) {
            while (l < right && array[right] >= pivot) right--;
            swap(array, l, right);
            while (l < right && array[l] <= pivot) l++;
            swap(array, l, right);
        }
        return l;
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public void mergesort(int[] array) {
        int[] copyarray = new int[array.length];
        mergesort0(array, copyarray, 0, array.length);
    }

    private void mergesort0(int[] array, int[] copyarray, int l, int r) {
        int right = r - 1;
        if (l < right) {
            int mid = l + (right - l >> 1);
            mergesort0(array, copyarray, l, mid + 1);
            mergesort0(array, copyarray, mid + 1, r);
            merge(array, copyarray, l, mid, r);
        }
    }

    private void merge(int[] array, int[] copyarray, int l, int mid, int r) {
        int right = r - 1;
        for (int i = l; i < r; i++) {
            copyarray[i] = array[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;
        for (; i <= mid && j <= right; k++) {
            if (copyarray[i] < copyarray[j]) array[k] = copyarray[i++];
            else array[k] = copyarray[j++];
        }
        while (i <= mid) {
            array[k++] = copyarray[i++];
        }

        while (j <= right) {
            array[k++] = copyarray[j++];
        }
    }

    public void heapsort(int[] array) {
        // init
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustMaxHeap(array, 0, i);
        }
    }

    private void adjustMaxHeap(int[] array, int index, int length) {

        int val = array[index];
        int index_val = index;
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length) {
                i = array[i] < array[i + 1] ? i + 1 : i;
            }
            if (array[i] < val) break;
            else {
                array[index_val] = array[i];
                index_val = i;
            }
        }
        array[index_val] = val;
    }
}
