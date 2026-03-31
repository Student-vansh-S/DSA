import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    static public class TreeNode {
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
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        f(root);
        return ans;
    }

    public String f(TreeNode node){
        if(node == null) return "";

        String left = f(node.left);
        String right = f(node.right);

        String str = node.val + "," + left + "," + right;

        map.put(str, map.getOrDefault(str, 0) + 1);    
        if(map.get(str) == 2) ans.add(node);

        return str.toString();
    }
}
