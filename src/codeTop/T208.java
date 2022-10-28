package codeTop;

public class T208 {
}

class Trie {
    private Trie[] nextNodes;
    private final int symbolNum = 26;
    private boolean end;

    public Trie() {
        nextNodes = new Trie[symbolNum];
        end = false;
    }

    public void insert(String word) {
        Trie treeNode = this;
        for (char c : word.toCharArray()) {
            if (treeNode.nextNodes[c - 'a'] == null) {
                treeNode.nextNodes[c - 'a'] = new Trie();
            }
            treeNode = treeNode.nextNodes[c - 'a'];
        }
        treeNode.end = true;
    }

    public boolean search(String word) {
        Trie treeNode = this;
        for (char c : word.toCharArray()) {
            treeNode = treeNode.nextNodes[c - 'a'];
            if (treeNode == null) {
                return false;
            }
        }
        return treeNode.end;
    }

    public boolean startsWith(String prefix) {
        Trie treeNode = this;
        for (char c : prefix.toCharArray()) {
            treeNode = treeNode.nextNodes[c - 'a'];
            if (treeNode == null) {
                return false;
            }
        }
        return true;
    }
}
