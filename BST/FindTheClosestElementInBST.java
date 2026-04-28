public class FindTheClosestElementInBST {
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
    public static TreeNode insert(TreeNode root , int val){
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left =insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Approach 1
    // static int minDiff = Integer.MAX_VALUE;
    // static int closest = -1;

    // public static int closestElement(TreeNode root, int k) {
    //     find(root, k);
    //     return closest;
    // }

    // public static void find(TreeNode root, int k) {
    //     if (root == null) return;

    //     int diff = Math.abs(root.val - k);

    //     if (diff < minDiff) {
    //         minDiff = diff;
    //         closest = root.val;
    //     }

    //     if (k < root.val) {
    //         find(root.left, k);
    //     } else {
    //         find(root.right, k);
    //     }
    // }
    
    // Approach 2
    public static int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            // update closest
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }

            // move in BST
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
    public static void main(String[] args) {
        int[] values = {4,1,6,5,7};
        TreeNode root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        System.out.println(closestValue(root, 3));
    }
}
