package lc;

/**
 * description:
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * 思路: 双指针,left指向相同字符得最左侧, right字符指向相同字符得最右侧
 * 同时使用一个write指针执行写入位置
 *
 * @author hawdies
 * @date 2021/8/21
 **/
public class N443StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || chars[i] != chars[i + 1]) {
                chars[write++] = chars[i];
                int num = i - left + 1;
                if (num > 1) {
                    String str = "" + num;
                    for (int j = 0; j < str.length(); j++) {
                        chars[write++] = str.charAt(j);
                    }
                }
                left = i + 1;
            }
        }
        return write;
    }
}
