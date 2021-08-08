package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/4/29
 **/
public class N068TextJustification {
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        N068TextJustification n068TextJustification = new N068TextJustification();
        List<String> strings = n068TextJustification.fullJustify(words, maxWidth);
        strings.stream().forEach(a -> System.out.println(a.length()));
        System.out.println(strings);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int l = i;
            int r = i;
            int totalChar = words[i].length();
            while (r < words.length && totalChar <= maxWidth) {
                if (r + 1 ==  words.length) {
                    r++;
                    break;
                }
                totalChar += words[++r].length() + 1;
            }
            String s = process(words, maxWidth, l, r);
            list.add(s);
            i = r;
        }
        String last = list.remove(list.size() - 1);
        last = processLastString(last, maxWidth);
        list.add(last);
        return list;
    }

    /**
     * @param words
     * @param maxWidth
     * @param l        inclusive
     * @param r        exculsive
     * @return
     */
    private String process(String[] words, int maxWidth, int l, int r) {
        int wordSize = r - l;
        StringBuilder sb = new StringBuilder();
        if (wordSize == 1) {
            sb.append(words[l]);
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int wordChars = 0;
        for (int i = l; i < r; i++) {
            wordChars += words[i].length();
        }
        int count = (maxWidth - wordChars) / (wordSize - 1);
        int remainder = (maxWidth - wordChars) % (wordSize - 1);
        for (int i = l; i < r; i++) {
            sb.append(words[i]);
            for (int j = 0; j < count && sb.length() < maxWidth - words[r - 1].length(); j++) {
                sb.append(" ");
            }
            if (remainder-- > 0) sb.append(" ");
        }
        return sb.toString();
    }

    private String processLastString(String s, int maxWidth) {
        String[] s1 = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String e : s1) {
            sb.append(e);
            if (sb.length() < maxWidth) {
                sb.append(" ");
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        int count = maxWidth - sb.length();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
