package zs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hawdies
 * @date 2021/7/18
 **/
public class N5156MaximumNumberOfWords {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                boolean flag = true;
                for (Character character : set) {
                    if (word.contains(character.toString())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
        }
        return count;
    }
}
