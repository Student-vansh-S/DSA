import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // first and last element
                if (j == 0 || j == i) {
                    curr.add(1);
                }
                // middle elements
                else {
                    int val =
                        ans.get(i - 1).get(j - 1) +
                        ans.get(i - 1).get(j);

                    curr.add(val);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
}