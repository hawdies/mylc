/**
 * @author hawdies
 * @Date 2021/3/25
 **/
public class N208Trie {
    private boolean isEnd;
    private N208Trie[] nexts;

    /**
     * Initialize your data structure here.
     */
    public N208Trie() {
        nexts = new N208Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 根节点不存值
        N208Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new N208Trie();
            }
            node = node.nexts[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        N208Trie node = this;
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
        N208Trie node = this;
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
