import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // check columns
        for (int j = 0; j < 9; j++) {

            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }

                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // check 3x3 boxes
        for (int blockRow = 0; blockRow < 3; blockRow++) {

            for (int blockCol = 0; blockCol < 3; blockCol++) {

                HashSet<Character> set = new HashSet<>();

                for (int i = blockRow * 3; i < blockRow * 3 + 3; i++) {

                    for (int j = blockCol * 3; j < blockCol * 3 + 3; j++) {

                        char ch = board[i][j];

                        if (ch == '.') {
                            continue;
                        }

                        if (set.contains(ch)) {
                            return false;
                        }

                        set.add(ch);
                    }
                }
            }
        }

        return true;
    }
}