public class SortedArrayToBalancedBST {
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
    public static void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    /*
    Leetcode Solution
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
    public TreeNode createBST(int[] arr, int st, int end){
        if (st>end) {
            return null;
        }
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right= createBST(arr, mid+1, end);
        return root;
    }
    */
    public static TreeNode createBST(int[] arr, int st, int end){
        if (st>end) {
            return null;
        }
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right= createBST(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,6,8,10,11,12};
        TreeNode root = createBST(arr, 0, arr.length-1);
        preOrder(root);
    }
}
