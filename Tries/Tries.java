public class Tries{
    static class Node {
        Node children[] = new Node[26];
        Boolean endOfWord = false;
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

    // Insert
    public static void insert(String word){ // O(L)
        word = word.toLowerCase();
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord=true;
    }

    // Search
    public static boolean search(String word){ //O(L)
        word = word.toLowerCase();
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static boolean wordBreak(String key){
        if (key.length()==0) {
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i","like","sam","samsung","mobile","ice"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
    /*
    -------Leetcode code---------

    class Trie {
    private Trie[]children;
    private boolean isEnd;

    public Trie() {
        children=new Trie[26];
        isEnd=false;        
    }
    
    public void insert(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                node.children[idx]=new Trie();
            }
            node=node.children[idx];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node=this;
        for (char c:prefix.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return true;
        
    }
}
    */
}