package others;

/**
 * 给定两个整数m,n
 * 需要修改m中多少位才能得到n
 * 可以使用位运算求解
 * 第一步先将m,n进行异或运算
 * 第二步统计1的个数
 *
 * @author hawdies
 * @Date 2021/2/28
 **/
public class ModifyBits {
    public static void main(String[] args) {
        System.out.println(needModifyBits(0x80000000, 1));
    }

    private static int needModifyBits(int m, int n) {
        int c = m ^ n;
        int count = 0;
        while (c != 0) {
            c = c & (c - 1);
            count++;
        }
        return count;
    }
}
