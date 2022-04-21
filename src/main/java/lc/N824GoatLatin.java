package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2022/4/21
 */
public class N824GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] splits = sentence.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < splits.length; i++) {
            String word = splits[i];
            char c = Character.toLowerCase(word.charAt(0));
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                word = word.substring(1) + word.charAt(0);
            }
            word += "ma";
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            word = word + sb;
            list.add(word);
        }
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog";
        N824GoatLatin demo = new N824GoatLatin();
        String s = demo.toGoatLatin(sentence);
        System.out.println(s);
    }

}
