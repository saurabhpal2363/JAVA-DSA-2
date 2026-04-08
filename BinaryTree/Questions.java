package BinaryTree;

import java.util.*;

public class Questions {
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

    public static int height(Node root) {   // O(n)
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh) + 1;
    }

    public static int count(Node root) {    // O(n)
        if(root == null) {
            return 0;
        }

        int lCount = count(root.left);
        int rCount = count(root.right);

        return lCount + rCount + 1;
    }

    public static int sum(Node root) {  // O(n)
        if(root == null) {
            return 0;
        }

        int lSum = sum(root.left);
        int rSum = sum(root.right);

        return lSum + rSum + root.data;
    }

    public static int diameter2(Node root) { // O(n^2)
        if(root == null) {
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {    // O(n)
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void KLevel(Node root, int level, int k) {    // O(n)
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    // Ques. Lowest Common Ancestors(Approach - 1)    -->  O(n)
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lowestCommonAncestor = path1.get(i-1);

        return lowestCommonAncestor;
    } 

    // Ques. Lowest Common Ancestors(Approach - 2)    -->  O(n)
    public static Node lowestCommonAncestor2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lowestCommonAncestor2(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor2(root.right, n1, n2);

        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

    // Ques. Minimum Distance between Nodes 
    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lowestCommonAncestor2(root, n1, n2);
        
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    // Ques. Kth Ancestor of Node 
    public static int KAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max+1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    // Ques. Transform to sum tree 
    public static int transform(Node root) {    // O(n)
        if(root == null) {
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(diameter(root).diam);

        // int k = 2;
        // KLevel(root, 1, k);

        // int n1 = 4, n2 = 5;
        // System.out.println(lowestCommonAncestor2(root, n1, n2).data);

        // int n1 = 4, n2 = 5;
        // System.out.println(minDist(root, n1, n2));

        // int n = 5, k = 1;
        // KAncestor(root, n, k);

        transform(root);
        preorder(root);
    }
}
