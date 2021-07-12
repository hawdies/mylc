package lc;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数. 数组已按照升序排序,编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * <p>
 * 思路: 根据citations[mid] >= (n - left)判断二分时该左移还是右移, 最终的距离n - left就是h指数
 * <p>
 * 时间复杂度O(logn)
 *
 * @author hawdies
 * @date 2021/7/11
 **/
public class N275HIndex2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= (n - left)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
