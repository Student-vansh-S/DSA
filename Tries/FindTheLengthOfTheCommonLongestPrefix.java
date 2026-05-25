public class FindTheLengthOfTheCommonLongestPrefix {
    // Trie Node
    static class Node {
        Node[] children = new Node[10];
    }

    Node root = new Node();

    // Insert number into Trie
    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - '0';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
    }

    // Find longest prefix match
    public int searchPrefix(String word) {

        Node curr = root;

        int len = 0;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - '0';

            if (curr.children[idx] == null) {
                break;
            }

            len++;

            curr = curr.children[idx];
        }

        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        // Insert arr1 numbers into Trie
        for (int num : arr1) {
            insert(String.valueOf(num));
        }

        int ans = 0;

        // Check prefixes with arr2
        for (int num : arr2) {

            ans = Math.max(
                ans,
                searchPrefix(String.valueOf(num))
            );
        }

        return ans;
    }
}
