import java.util.*;
class TopViewOfTree {
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
    }

    public static void main(String[] args) {
        // int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        /*
                 1
                / \
               2   3
              / \   
             4   5
            /     \
           9       6
          /         \
        10           7
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
    }
}