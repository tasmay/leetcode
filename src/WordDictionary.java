import Trie.TrieNode;

public class WordDictionary {

    private static TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public static void addWord(String word) {
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

    public static boolean dfs(int index, TrieNode root, String word) {
        TrieNode current = root;
        for(int i=index; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(int j=0; j < current.children.length; j++) {
                    if (current.children[j] != null && dfs(i+1, current.children[j], word))
                        return true;
                }
                return false;
            } else {
                if (current.children[c - 'a'] == null) return false;
                current = current.children[c-'a'];
            }
        }
        return current.isLeafNode();
    }

    public static boolean search(String word) {
        return dfs(0, root, word);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
