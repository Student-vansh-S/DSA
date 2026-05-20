import java.util.HashMap;
import java.util.List;

public class WordBreak {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root;

    // insert into trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    // memoization map
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean breakWord(String key) {
        // base case
        if (key.length() == 0) {
            return true;
        }
        // already solved
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            // prefix not found
            if (curr.children[idx] == null) {
                break;
            }
            curr = curr.children[idx];
            // valid word found
            if (curr.endOfWord) {
                if (breakWord(key.substring(i + 1))) {
                    memo.put(key, true);
                    return true;
                }
            }
        }
        memo.put(key, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        for (String word : wordDict) {
            insert(word);
        }
        return breakWord(s);
    }
}
