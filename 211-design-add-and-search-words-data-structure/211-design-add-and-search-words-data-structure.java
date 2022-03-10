class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord = false;
    TrieNode() {
        children  = new HashMap<>();
        isWord = false;
    }
}
class WordDictionary {
    TrieNode root = null;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c))
                current.children.put(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }
    private boolean dfs(int index, String word, TrieNode node) {
        TrieNode current = node;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (current.children.get(j) != null) {
                        TrieNode child = current.children.get(j);
                        if (dfs(i + 1, word, child)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                if (!current.children.containsKey(c))
                    return false;
                current = current.children.get(c);
            }
        }
        return current.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */