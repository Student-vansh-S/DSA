public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int top = -1; // simulate stack top
        for (char c : arr) {
            if (top >= 0 && arr[top] == c) {
                top--; // pop
            } else {
                arr[++top] = c; // push
            }
        }
        // Result string
        return new String(arr, 0, top + 1);
    }
    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }
}