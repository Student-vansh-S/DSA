public class LongestCommonSUffixQueries {
    static class Node {
        Node[] children = new Node[26];
        int index = -1;
        int len = Integer.MAX_VALUE;
    }
    Node root = new Node();

    // insert reversed word
    public void insert(String word, int idx) {
        Node curr = root;
        // store shortest word index
        if (word.length() < curr.len) {
            curr.len = word.length();
            curr.index = idx;
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new Node();
            }
            curr = curr.children[c];
            if (word.length() < curr.len) {
                curr.len = word.length();
                curr.index = idx;
            }
        }
    }

    // search best suffix match
    public int search(String word) {
        Node curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                break;
            }
            curr = curr.children[c];
        }
        return curr.index;
    }

    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery) {

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {

            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {

            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}
