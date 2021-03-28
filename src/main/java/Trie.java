/**
 * @author hawdies
 * @Date 2021/3/25
 **/
public class Trie {
    private boolean isEnd;
    private Trie[] nexts;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        nexts = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 根节点不存值
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new Trie();
            }
            node = node.nexts[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nexts[c - 'a'] == null) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.nexts[c - 'a'] == null) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }
        return true;
    }
}
