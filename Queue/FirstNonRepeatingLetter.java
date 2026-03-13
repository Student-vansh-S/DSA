import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static void printNonRepeating(String str){
        /*int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1; */
        int freq[] = new int[26]; // 'a' - 'z'
        Queue<Character> q = new ArrayDeque<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println(-1 + " ");
            } else{
                System.out.println(q.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
