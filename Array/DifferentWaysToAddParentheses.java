import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentWaysToAddParentheses {
    class Solution {
        ArrayList<Integer>[][] memo;

        public List<Integer> diffWaysToCompute(String expression) {
            int n = expression.length();
            memo = new ArrayList[n][n];
            if (n == 1) {
                return new ArrayList<Integer>(Arrays.asList(Integer.parseInt(expression)));
            }
            return helper(expression, 0, n - 1);
        }

        private List<Integer> helper(String expression, int i, int j) {
            if (j - i <= 1) {
                return new ArrayList<Integer>(Arrays.asList(Integer.parseInt(expression.substring(i, j + 1))));
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int k = i; k <= j - 2; k = k + 2) {
                char op = expression.charAt(k + 1);
                if (op > 47 && op < 58) {
                    ++k;
                }
                List<Integer> left = helper(expression, i, k);
                List<Integer> right = helper(expression, k + 2, j);
                List<Integer> cur = getResult(expression, k + 1, left, right);
                result.addAll(cur);
            }
            memo[i][j] = result;
            return memo[i][j];
        }

        private List<Integer> getResult(String expression, int op, List<Integer> left, List<Integer> right) {
            return switch (expression.charAt(op)) {
                case '+' -> addOp(left, right);
                case '-' -> subtractOp(left, right);
                case '*' -> multiplyOp(left, right);
                default -> new ArrayList<Integer>();
            };
        }

        private List<Integer> addOp(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<>();
            for (int leftVal : left) {
                for (int rightVal : right) {
                    result.add(leftVal + rightVal);
                }
            }
            return result;
        }

        private List<Integer> subtractOp(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<>();
            for (int leftVal : left) {
                for (int rightVal : right) {
                    result.add(leftVal - rightVal);
                }
            }
            return result;
        }

        private List<Integer> multiplyOp(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<>();
            for (int leftVal : left) {
                for (int rightVal : right) {
                    result.add(leftVal * rightVal);
                }
            }
            return result;
        }
    }
}
