public class RemoveDuplicates {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        String lstr = str.toLowerCase();
        if (idx == lstr.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = lstr.charAt(idx);
        // Skip non-alphabet characters
        if (currChar < 'a' || currChar > 'z') {
            removeDuplicates(lstr, idx + 1, newStr, map);
            return;
        }
        if (map[currChar - 'a']) {
            removeDuplicates(lstr, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            newStr.append(currChar);
            removeDuplicates(lstr, idx + 1, newStr, map);
        }
    }

    public static void main(String[] args) {
        String str = "vanshsaini";
        removeDuplicates(str, 0, new StringBuilder(), new boolean[26]);
    }
}
