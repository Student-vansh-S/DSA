// import java.util.ArrayList;

public class KthSmallestElementInBST {
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
    // Approach 1
    // public static void inOrder(TreeNode root ,ArrayList<Integer> ans){
    //     if (root == null) {
    //         return;
    //     }
    //     inOrder(root.left, ans);
    //     ans.add(root.val);
    //     inOrder(root.right , ans );
    // }
    // public static int kthSmallest(TreeNode root, int k) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     inOrder(root, ans);
    //     if (k > ans.size()) {
    //         return -1;
    //     }
    //     return ans.get(k);   
    // }

    // Approach 2
    int index = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        index++;
        if (index == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }



    // public static TreeNode insert(TreeNode root , int val){
    //     if (root == null) {
    //         root = new TreeNode(val);
    //         return root;
    //     }
    //     if (root.val > val) {
    //         root.left =insert(root.left, val);
    //     }else{
    //         root.right = insert(root.right, val);
    //     }
    //     return root;
    // }

    public static void main(String[] args) {
        // int[] values = {8,5,3,1,4,6,10,11,14};
        // TreeNode root = null;
        // for(int i=0;i<values.length;i++){
        //     root = insert(root, values[i]);
        // }
        // System.out.println(kthSmallest(root, 3));
    }
}
