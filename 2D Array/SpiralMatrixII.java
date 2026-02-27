import java.util.Arrays;
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = n - 1;

        int[][] matrix = new int[n][n];
        int count = 1;  // FIX: make local

        while (startRow <= endRow && startCol <= endCol) {

            // Top
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = count++;
            }

            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol] = count++;
            }

            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) break;
                matrix[endRow][j] = count++;
            }

            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) break;
                matrix[i][startCol] = count++;
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
}