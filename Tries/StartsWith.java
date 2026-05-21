public class StartsWith {
    static class Node {
        Node children[] = new Node[26];
        Boolean eow = false;

        public Node(){
            for(int i=0;i<26;i++){
                this.children[i] = null;
            }
        }
    }

        public static Node root = new Node();

        public static void insert(String word){
            word = word.toLowerCase();
            Node curr = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i)-'a';
                if (curr.children[idx]==null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }

        public static boolean startsWith(String prefix){
            prefix = prefix.toLowerCase();
            Node curr = root;
            for(int i=0;i<prefix.length();i++){
                int idx = prefix.charAt(i)-'a';
                if (curr.children[idx]==null) {
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args) {
            String words[] = {"zebra","dog","duck","dove"};
            for(int i=0;i<words.length;i++){
                insert(words[i]);
            }
            System.out.println(startsWith("doc"));
        }
}
