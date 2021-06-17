/**
 *
 * description: 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 *
 *
 * 思路: 模拟法求解
 * @author hawdies
 * @date 2021/6/17
 **/
public class N065VaildNumber {

    public boolean isNumber(String s) {
        boolean flag = false;
        int index = 0;
        int pre = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') index++;
        pre = index;
        index = findUnsignInteger(s, index);
        if (index > pre) flag = true;
        if (index < s.length() && s.charAt(index) == '.') index++;
        pre = index;
        index = findUnsignInteger(s, index);
        flag = flag || index > pre;
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                index++;
            }
            pre = index;
            index = findUnsignInteger(s, index);
            flag = flag && index > pre;
        }
        return flag && index == s.length();
    }


    private int findUnsignInteger(String s, int index) {
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
        }
        return index;
    }
}
