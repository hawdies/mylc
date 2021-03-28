package others;

/**
 * 使用位运算判断一个树是否是2的整数次方
 * @author hawdies
 * @Date 2021/2/28
 **/
public class TwoPower {
    public static void main(String[] args) {
        System.out.println(is2Power(-3));
    }
    private static boolean is2Power(int n) {
        if (n == 0) return false;

        n = n < 0 ? -n : n;
        n = n & (n - 1);
        return n == 0 ? true : false;
    }
}
