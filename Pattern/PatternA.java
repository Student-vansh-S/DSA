public class PatternA{
public static void main(String[] args) {
        int rows = 4;   // total rows
        int cols = 6;   // total columns

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // Print * for first row, last row, first col, last col
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // move to next line
        }
    }
}