package lc;

import java.util.*;

/**
 * 同字符异位分组
 *
 * @author hawdies
 * @Date 2021/2/23
 **/
public class N049GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<String> list = null;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
