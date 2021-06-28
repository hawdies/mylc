package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 *<br>
 * 思路: 回溯 + 位运算
 *
 * 由题可知需要通过,回溯遍历所有的可能性,并找到其中最长的长度.长度范围是[0, 26].
 * 可将原每个字符串用位表示,一个int 32位,故可以使用一个int来表示arr数组中的一个String.
 * 将arr(List&lt;String&gt; --> masks(List&lt;Integer&gt;) 即将原来的String转为Integer来表示,int中每一个bit表示对应的字母是否存在.
 * 在arr -> masks的过程中去除字符串中存在的重复字符的元素
 * @author hawdies
 * @date 2021/6/19
 **/
public class N1239MaximunConcatenatedUniqueCharacters {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("yy");
        arr.add("bkhwmpbiisbldzknpm");
        N1239MaximunConcatenatedUniqueCharacters demo = new N1239MaximunConcatenatedUniqueCharacters();
        int maxLength = demo.maxLength(arr);
        System.out.println(maxLength);

    }

    private int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String str : arr){
            int mask = 0;
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i) - 'a';
                // 如果str中有重复字符则brek
                if ((1 << ch & mask) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            // mask > 0用排除无效的元素,在上文中对存在重复字符的字符串设置mask = 0
            if (mask > 0) {
                masks.add(mask);
            }
        }
        backtrack(masks, 0, 0);
        return ans;
    }

    private void backtrack(List<Integer> masks, int index, int pos) {
        if (index == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(pos));
            return;
        }
        int cur = masks.get(index);
        if ((pos & cur) == 0) {
            backtrack(masks, index + 1, cur | pos);
        }
        backtrack(masks, index + 1, pos);
    }
}
