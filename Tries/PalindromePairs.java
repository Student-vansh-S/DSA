import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int index = -1;
        List<Integer> palSuffix = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, res);
        }

        return res;
    }

    private void insert(TrieNode root, String word, int idx) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null)
                node.child[c] = new TrieNode();

            if (isPal(word, 0, i))
                node.palSuffix.add(idx);

            node = node.child[c];
        }

        node.index = idx;
    }

    private void search(TrieNode root, String word, int idx, List<List<Integer>> res) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            if (node.index != -1 && node.index != idx && isPal(word, i, word.length() - 1)) {
                res.add(Arrays.asList(idx, node.index));
            }

            int c = word.charAt(i) - 'a';
            node = node.child[c];

            if (node == null) return;
        }

        if (node.index != -1 && node.index != idx) {
            res.add(Arrays.asList(idx, node.index));
        }

        for (int j : node.palSuffix) {
            if (j != idx)
                res.add(Arrays.asList(idx, j));
        }
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
