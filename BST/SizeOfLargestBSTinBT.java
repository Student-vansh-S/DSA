public class SizeOfLargestBSTinBT {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    // Leetcode 1373 (Maximum Sum BST in Binary tree)
    // public int maxSumBST(TreeNode root) {
    //     helper(root);
    //     return maxSum;
    // }
    // public Info helper(TreeNode root) {
    //     if (root == null) {
    //         return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    //     }
    //     Info left = helper(root.left);
    //     Info right = helper(root.right);

    //     // Check BST condition
    //     if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
    //         int currSum = left.sum + right.sum + root.val;
    //         maxSum = Math.max(maxSum, currSum);
    //         int min = Math.min(root.val, left.min);
    //         int max = Math.max(root.val, right.max);
    //         return new Info(true, currSum, min, max);
    //     }
    //     return new Info(false, 0, 0, 0);
    // }
    public static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    static int maxBST = 0;
    
    public static Info largestBST(TreeNode root){
        if (root == null) {
            return new Info(true, 0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.val,Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val,Math.max(leftInfo.max, rightInfo.max));

        // isBST
        if (root.val <= leftInfo.max || root.val >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        else if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.right = new TreeNode(20);
        root.left.left = new TreeNode(5);

        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        largestBST(root);
        System.out.println("largest BST size : "+ maxBST);
    }
}
