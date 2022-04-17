package lc;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author hawdies
 * @date 2022/4/17
 */
public class N819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        String[] splits = paragraph.split("[^a-z|A-Z]+");
        for (String split : splits) {
            split = split.toLowerCase();
            if (!set.contains(split)) {
                map.put(split, map.getOrDefault(split, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        return list.get(0).getKey();
    }
}
