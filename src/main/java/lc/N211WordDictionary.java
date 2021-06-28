package lc;

/**
 * description: 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * <p>
 * 思路: 插入和查找和Tire树的思路相同,重点需要处理字符为'.'的情况,如果为'.'.则进行深度优先遍历next不为空的节点,只要有一个为true则结果为true
 *
 * @author hawdies
 * @date 2021/4/22
 **/
public class N211WordDictionary {
    private static class Trie {
        Trie[] next = new Trie[26];
        boolean isEnd;
    }

    private Trie root;

    public N211WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new Trie();
            }
            p = p.next[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, Trie root) {
        Trie p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (p.next[j] != null && dfs(word.substring(i + 1), p.next[j])) {
                        return true;
                    }
                }
            } else {
                if (p.next[c - 'a'] == null) return false;
                p = p.next[c - 'a'];
            }
        }
        return p.isEnd;
    }

}
