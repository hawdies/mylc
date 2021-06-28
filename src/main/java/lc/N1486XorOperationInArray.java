package lc;

/**
 * description: 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 思路:
 * 方法1:用模拟法求解
 * 方法2: 利用异或运算性质用数学法求解
 * 记 ⊕ 为异或运算，异或运算满足以下性质：
 * <p>
 * x ⊕ x = 0;  x ⊕ x = 0；
 * x ⊕ y = y ⊕ x（交换律）；
 * (x ⊕ y) ⊕ z = x ⊕ (y ⊕ z)（结合律）；
 * x⊕y⊕y=x（自反性）；
 * ∀i∈Z，有4i⊕(4i+1)⊕(4i+2)⊕(4i+3)=0。
 *
 * @author hawdies
 * @date 2021/5/7
 **/
public class N1486XorOperationInArray {
    public int xorOperation(int n, int start) {
        int e = n & start & 1;
        int s = start >>> 1;
        return (sumXor(s - 1) ^ sumXor(s + n - 1)) << 1 | e;
    }

    // 模数可能为-1, 此时应该和模数为3一样返回0.
    // 模数不可能取-2, -3.
    private int sumXor(int x) {
        if (x % 4 == 0) return x;
        if (x % 4 == 1) return 1;
        if (x % 4 == 2) return x + 1;
        return 0;
    }
}
