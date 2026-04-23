public class BackspaceStringCompare {
    // Approach 1
    // public boolean backspaceCompare(String s, String t) {
    //     return build(s).equals(build(t));
    // }

    // private String build(String str) {
    //     Stack<Character> stack = new Stack<>();

    //     for (char c : str.toCharArray()) {
    //         if (c == '#') {
    //             if (!stack.isEmpty()) {
    //                 stack.pop();
    //             }
    //         } else {
    //             stack.push(c);
    //         }
    //     }

    //     StringBuilder result = new StringBuilder();
    //     for (char c : stack) {
    //         result.append(c);
    //     }

    //     return result.toString();
    // }

    // Approach 2
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {

            // process s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }

            // process t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            // compare chars
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
