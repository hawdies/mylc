package others;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/4/12
 **/
public class MergeSort {
    private static int[] tmp;

    public static void main(String[] args) {
        int[] array = {4, 535, 54, 24, 1, 5, 68, 1, 5, 65, 6, 6, 2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        tmp = new int[array.length];
        dfs(array, 0, array.length - 1);
    }

    private static void dfs(int[] array, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        dfs(array, l, mid);
        dfs(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private static void merge(int[] array, int l, int mid, int r) {
        int p = l;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            tmp[p++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            tmp[p++] = array[p1++];
        }
        while (p2 <= r) {
            tmp[p++] = array[p2++];
        }
        if (r + 1 - l >= 0) System.arraycopy(tmp, l, array, l, r + 1 - l);
    }
}
