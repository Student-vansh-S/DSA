import java.util.ArrayList;

public class LowestCommonAncestor {
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

    public static boolean getPath(TreeNode root , int n, ArrayList<TreeNode> path){
    if (root == null) {
        return false;
    }

    // Step 1: add current node
    path.add(root);

    // Step 2: check if found
    if (root.val == n) {
        return true;
    }

    // Step 3: search in left or right
    if (getPath(root.left, n, path) || getPath(root.right, n, path)) {
        return true;
    }

    // Step 4: backtrack
    path.remove(path.size()-1);
    return false;
} 
    public static TreeNode lca(TreeNode root , int n1 , int n2){
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for(; i<path1.size() && i<path2.size();i++){
            if (path1.get(i)!= path2.get(i)) {
                break;
            }
        }
        TreeNode LCA = path1.get(i-1);
        return LCA;
    }

    public static TreeNode LCA2(TreeNode root, int n1,int n2){
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }
        TreeNode leftLca = LCA2(root.left,n1,n2);
        TreeNode rightLca = LCA2(root.right,n1,n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }
    public static void main(String[] args) {

        /*
                 1
                /  \
               2    3
              / \   /\ 
             4   5 8  12
            /     \
           9       6
          /        
        10         
        */
    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(9);
    root.left.left.left.left = new TreeNode(10);

    root.left.right = new TreeNode(5);  
    root.left.right.right = new TreeNode(6); 

    root.right = new TreeNode(3);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(12);
        System.out.println(LCA2(root, 4, 5).val);
    }
}
