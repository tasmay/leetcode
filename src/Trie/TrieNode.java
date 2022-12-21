package Trie;

public class TrieNode {
    private char value;
    private boolean isLeafNode;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public void setValue(char val) {
        value = val;
    }

    public void setLeafNode() {
        isLeafNode = true;
    }

    public boolean isLeafNode() {
        return isLeafNode;
    }

    public void setChildren(char ch, TrieNode node) {
        children[ch-'a'] = node;
    }
}
