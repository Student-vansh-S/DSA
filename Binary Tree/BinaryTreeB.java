import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void preOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int count(Node root) {
            if (root == null) {
                return 0;
            }
            int leftcount = count(root.left);
            int rightcount = count(root.right);
            return leftcount + rightcount + 1;
        }

        public int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return leftSum + rightSum + root.data;
        }

        // public static class Info{
        // int diam;
        // int height;
        // public Info(int diam, int height){
        // this.diam = diam;
        // this.height = height;
        // }
        // }

        // public Info diameter(Node root){
        // // Approach 1 TC - O(n^2)
        // // if (root == null) {
        // // return 0;
        // // }
        // // int leftHeight = height(root.left);
        // // int rightHeight = height(root.right);
        // // int leftDiameter = diameter(root.left);
        // // int rightDiameter = diameter(root.right);
        // // int self = leftHeight + rightHeight +1;
        // // return Math.max(self , Math.max(leftDiameter, rightDiameter));

        // // Approach 2 TC - O(n)
        // if (root == null) {
        // return new Info(0,0);
        // }
        // Info leftInfo = diameter(root.left);
        // Info rightInfo = diameter(root.right);

        // int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height
        // + rightInfo.height+1);
        // int ht = Math.max(leftInfo.height,rightInfo.height)+1;

        // return new Info(diam, ht);
        // }

        static class Info {
            Node node;
            int hd;

            public Info(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public void topView(Node root) {
            if (root == null) {
                return;
            }

            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0, max = 0;

            q.add(new Info(root, 0));

            while (!q.isEmpty()) {
                Info curr = q.remove();

                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }

        public void kLevel(Node root, int level , int k){
            if (root == null) { 
                return;
            }
            if (level == k) {
                System.out.print(root.data+ " ");                
            }
            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }
    }

    public static void main(String[] args) {
        // int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
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

        BinaryTree b = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.left.left.left = new Node(10);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(8);
        root.right.right = new Node(12);
        root.right.right = new Node(6);

        // System.out.println("Root :"+ root.data);
        // b.preOrder(root);
        // b.inOrder(root);
        // b.postOrder(root);
        // b.levelOrder(root);
        // System.out.println(b.height(root));
        // System.out.println(b.count(root));
        // System.out.println(b.sum(root));
        // System.out.println(b.diameter(root).diam);
        b.topView(root);
        // b.kLevel(root, 1, 3);
    }
}