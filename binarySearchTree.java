// create binary search tree and print it and it's size, height and traverse it & others++

public class binarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // pair of node and state
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // constructor
    public static Node construct(int[] arr, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);
        Node node = new Node(data, lc, rc);
        return node;
    }

    // display binary search tree
    public static void display(Node node) {
        if(node == null) {
            return;
        }
        String str = "";
        str += node.left == null? "." : node.left.data + " ";
        str += " <- " + node.data + " -> ";
        str += node.right == null? "." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    // size of binary tree
    public static int size(Node node) {
        if(node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    // sum of binary tree
    public static int sum(Node node) {
        if(node == null) {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }

    // max & min of bst
    public static int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        }
        return node.data;
    }
    public static int min(Node node) {
        if(node.left != null) {
            return min(node.left);
        }
        return node.data;
    }

    // find in bst
    public static boolean find(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(data > node.data) {
            return find(node.right, data);
        }
        else if(data < node.data) {
            return find(node.left, data);
        }
        else {
            return true;
        }
    }

    // add a node in bst
    public static Node add(Node node, int data) {
        if(node == null) {
            return new Node(data, null, null);
        }
        if(data > node.data) {
            node.right = add(node.right, data);
        }
        else if(data < node.data) {
            node.left = add(node.left, data);
        }
        return node;
    }

    // remove a node from bst
    public static Node remove(Node node, int data) {
        if(node == null) {
            return null;
        }
        if(data > node.data) {
            node.right = remove(node.right, data);
        }
        else if(data < node.data) {
            node.left = remove(node.left, data);
        }
        else {
            if(node.left != null && node.right != null) {
                // 2 children
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            }
            else if(node.left != null) {
                // only 1 left child
                return node.left;
            }
            else if(node.right != null) {
                // only 1 right child
                return node.right;
            }
            else {
                // no child
                return null;
            }
        }
        return node;
    }

    // inorder preorder postorder
    public static void inorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }
    public static void preorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    public static void postorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // replace with sum of larger
    static int sumRWSOL = 0;
    public static void replaceWithSumOfLarger(Node node) {
        if(node == null) {
            return;
        }
        // reverse inorder
        replaceWithSumOfLarger(node.right);
        int od = node.data;
        node.data = sumRWSOL;
        sumRWSOL += od;
        replaceWithSumOfLarger(node.left);
    }

    // lca (lowest common ancestor) of two nodes with given data in bst
    public static int lca(Node node, int d1, int d2) {
        if(d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        }
        else if(d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        }
        else {
            return node.data;
        }
    }

    // print values in given range
    public static void printInRange(Node node, int d1, int d2) {
        if(node == null) {
            return;
        }
        if(d1 < node.data && d2 < node.data) {
            printInRange(node.left, d1, d2);
        }
        if(d1 > node.data && d2 > node.data) {
            printInRange(node.right, d1, d2);
        }
        else {
            printInRange(node.left, d1, d2);
            System.out.println(node.data);
            printInRange(node.right, d1, d2);
        }
    }

    // target sum pair in bst
    public static void targetSumPair(Node root, Node node, int target) {
        if(node == null) {
            return;
        }
        // inorder traversal, for each value, c = target - node.val, if c is present, return that pair
        targetSumPair(root, node.left, target);
        int comp = target - node.data;
        if(node.data < comp && find(node, comp)) {
            System.out.println(node.data + " " + comp);
        }
        targetSumPair(root, node.right, target);
    }
    
    // is it a bst
    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }
    public static BSTPair isBST(Node node) {
        if(node == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);
        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        return mp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
        System.out.println("Size: " + size(root));
        System.out.println("Sum: " + sum(root));
        System.out.println("Max & Min: " + max(root) + " & " + min(root));
        //System.out.println("25 present? " + find(root, 25));
        /*add(root, 90);
        display(root);*/
        /*remove(root, 87);
        display(root);*/
        //System.out.println("LCA of 12 and 30: " + lca(root, 12, 30));
        //printInRange(root, 27, 72);
        //targetSumPair(root, root, 125);
        /*BSTPair np = isBST(root);
        System.out.println(np.isBST);*/
    }
}
