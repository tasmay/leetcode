/*
* All kinds of Trie Problems
* */

package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c-'a'] == null) {
                TrieNode node = new TrieNode();
                node.setValue(c);
                current.children[c-'a'] = node;
            }
            current = current.children[c-'a'];
        }
        current.setLeafNode();
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c-'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return current.isLeafNode();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c-'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return true;
    }
}
