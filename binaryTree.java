// create binary tree and print it and it's size, height and traverse it & others++

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class binaryTree {
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

    // display binary tree
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

    // maximum element of binary tree
    public static int max(Node node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        return tm;
    }

    // height of binary tree
    public static int height(Node node) {
        if(node == null) {
            return -1; // -1 as this height is for edges
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    // recursive pre-order traversal
    public static void preorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    // recursive post-order traversal
    public static void postorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    // recursive in-order traversal
    public static void inorderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }
    // iterative pre in post order traversals
    public static void iterativePreInPostOrderTraversals(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair(node, 1);
        st.push(rootPair);
        String pre = "";
        String in = "";
        String post = "";
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.state == 1) { // pre, st++, left
                pre += top.node.data + " ";
                top.state++;
                if(top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            }
            else if(top.state == 2) { // in, st++, right
                in += top.node.data + " ";
                top.state++;
                if(top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            }
            else { // post, pop
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println("Pre: " + pre);
        System.out.println("In: " + in);
        System.out.println("Post: " + post);
    }
    // level-order traversal
    public static void levelorderTraversal(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while(mq.size() > 0) {
            int count = mq.size();
            for(int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                if(node.left != null) {
                    mq.add(node.left);
                }
                if(node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println("");
        }
    }

    // find key in binary tree
    public static boolean findValueInTree(Node node, int key) {
        if(node == null) {
            return false;
        }
        if(node.data == key) {
            return true;
        }
        boolean findInLeftChild = findValueInTree(node.left, key);
        if(findInLeftChild) {
            return true;
        }
        boolean findInRightChild = findValueInTree(node.right, key);
        if(findInRightChild) {
            return true;
        }
        return false;
    }

    // node to root path
    public static ArrayList<Integer> nodeToRootPath(Node node, int key) {
        if(findValueInTree(node, key)) {
            if(node.data == key) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.data);
                return list;
            }
            if(findValueInTree(node.left, key)) {
                ArrayList<Integer> path = nodeToRootPath(node.left, key);
                if(path.size() > 0) {
                    path.add(node.data);
                    return path;
                }
            }
            if(findValueInTree(node.right, key)) {
                ArrayList<Integer> path = nodeToRootPath(node.right, key);
                if(path.size() > 0) {
                    path.add(node.data);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }

    // print all elements of kth level (print k levels down)
    public static void printKLevelsDown(Node node, int k, Node blocker /* parameter used in next function */) {
        if(node == null || k < 0 || node == blocker) {
            return;
        }
        if(k == 0) {
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k - 1, blocker);
        printKLevelsDown(node.right, k - 1, blocker);
    }

    // print nodes k distance away (print nodes k levels far) (a bit wrong, in process)
    public static ArrayList<Node> returnNodeForNodeToRootPath(Node node, int key) {
        if(findValueInTree(node, key)) {
            if(node.data == key) {
                ArrayList<Node> list = new ArrayList<>();
                list.add(node);
                return list;
            }
            if(findValueInTree(node.left, key)) {
                ArrayList<Node> path = returnNodeForNodeToRootPath(node.left, key);
                if(path.size() > 0) {
                    path.add(node);
                    return path;
                }
            }
            if(findValueInTree(node.right, key)) {
                ArrayList<Node> path = returnNodeForNodeToRootPath(node.right, key);
                if(path.size() > 0) {
                    path.add(node);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }
    public static void printKLevelsFar(Node node, int key, int k) {
        ArrayList<Node> path = returnNodeForNodeToRootPath(node, key); // node to root path
        for(int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), k - i, i == 0? null : path.get(i - 1));
        }
    }

    // path to leaf from root
    public static void pathToLeafFromRoot(Node node, String path, int sum, int low, int high) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) { // at leaf
            sum += node.data;
            if(sum >= low && sum <= high) {
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, low, high);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, low, high);
    }

    // transform to left cloned tree
    public static Node createLeftCloneTree(Node node) {
        if(node == null) {
            return null;
        }
        Node lcr = createLeftCloneTree(node.left); // left clone root
        Node rcr = createLeftCloneTree(node.right); // right clone root
        Node nln = new Node(node.data, lcr, null);
        node.left = nln;
        node.right = rcr;
        return node;
    }
    // transform back from left cloned tree to normal
    public static Node transformBackFromLeftClonedTree(Node node) {
        if(node == null) {
            return null;
        }
        Node lnn = transformBackFromLeftClonedTree(node.left.left); // left normalized node
        Node rnn = transformBackFromLeftClonedTree(node.right); // right normalized node
        node.left = lnn;
        node.right = rnn;
        return node;
    }

    // print single child nodes
    public static void printSingleChildNodes(Node node, Node parent) {
        if(node == null) {
            return;
        }
        if(parent != null && parent.left == node && parent.right == null) {
            System.out.println(parent.data);
        }
        else if(parent != null && parent.right == node && parent.left == null) {
            System.out.println(parent.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    // remove leaves from binary tree
    public static Node removeLeaves(Node node) {
        if(node == null) {
            return null;
        }
        if(node.left == null && node.right == null) {
            return null; // if it is a leaf, return null in place of it
        }
        node.left = removeLeaves(node.left); // new left child
        node.right = removeLeaves(node.right); // new right child
        return node;
    }

    // diameter of binary tree (this is inefficient approach)
    public static int diameter(Node node) {
        if(node == null) {
            return 0;
        }
        int ld = diameter(node.left);
        int rd = diameter(node.right);
        int f = height(node.left) + height(node.right) + 2;
        int diameter = Math.max(f, Math.max(ld, rd));
        return diameter;
    }

    // tilt of a binary tree
    static int tilt = 0;
    public static int tiltSum(Node node) {
        if(node == null) {
            return 0;
        }
        int ls = tiltSum(node.left);
        int rs = tiltSum(node.right);
        int localTilt = Math.abs(ls - rs);
        tilt += localTilt;
        int sum = ls + rs + node.data;
        return sum;
    }

    // is it a balanced binary tree
    static boolean isBal = true;
    public static int isBalanced(Node node) {
        if(node == null) {
            return 0;
        }
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);
        int gap = Math.abs(lh - rh);
        if(gap > 1) {
            isBal = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);
        // constructor
        Stack<Pair> st = new Stack<>();
        st.push(rootPair);
        int idx = 0;
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.state == 1) {
                idx++;
                if(idx < arr.length && arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null); // left node
                    Pair lp = new Pair(top.node.left, 1); // left pair
                    st.push(lp);
                }
                else {
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state == 2) {
                idx++;
                if(idx < arr.length && arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null); // right node
                    Pair rp = new Pair(top.node.right, 1); // right pair
                    st.push(rp);
                }
                else {
                    top.node.right = null;
                }
                top.state++;
            }
            else {
                st.pop();
            }
        }
        display(root);
        System.out.println("Size: " + size(root));
        System.out.println("Root: " + sum(root));
        System.out.println("Max: " + max(root));
        System.out.println("Height: " + height(root));
        /*System.out.println("PreOrder Traversal: ");
        preorderTraversal(root);
        System.out.println("");
        System.out.println("PostOrder Traversal: ");
        postorderTraversal(root);
        System.out.println("");
        System.out.println("InOrder Traversal: ");
        inorderTraversal(root);
        System.out.println("");
        System.out.println("LevelOrder Traversal: ");
        levelorderTraversal(root);
        iterativePreInPostOrderTraversals(root);*/
        /*System.out.println(nodeToRootPath(root, 70));*/
        /*printKLevelsDown(root, 2);*/
        /*printKLevelsFar(root, 75, 2); // 25,60,70 actual output*/
        /*pathToLeafFromRoot(root, "", 0, 0, 10000);*/
        /*createLeftCloneTree(root);
        display(root);
        System.out.println("break-point");
        transformBackFromLeftClonedTree(root);
        display(root);*/
        /*printSingleChildNodes(root, null);*/
        /*removeLeaves(root);
        display(root);*/
        /*System.out.println(diameter(root));*/
        /*tiltSum(root);
        System.out.println(tilt);*/
        /*isBalanced(root);
        System.out.println(isBal);*/
    }
}
