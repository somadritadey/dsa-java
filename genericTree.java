// create generic tree and print it and it's size, height and traverse it & others++

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class genericTree {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // display tree
    public static void display(Node node) {
        // itself and it's children
        String str = node.data + " -> ";
        for(Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        // children and below
        for(Node child: node.children) {
            display(child); // recursion to print entire family
        }
    }

    // size of tree
    public static int size(Node node) {
        int size = 1;
        for(Node child: node.children) {
            int childSize = size(child);
            size += childSize;
        }
        return size;
    }

    // maximum valued element in a generic tree
    public static int maximum(Node node) {
        int max = Integer.MIN_VALUE; // minus infinity
        for(Node child: node.children) {
            int childMax = maximum(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);
        return max;
    }

    // height of tree
    public static int height(Node node) {
        int ht = -1;
        for(Node child: node.children) {
            int cht = height(child);
            ht = Math.max(cht, ht);
        }
        ht++;
        return ht;
    }

    // pre order traversal
    public static void preOrderTraversal(Node node) {
        // recursive
        System.out.print(node.data + " ");
        for(Node child: node.children) {
            preOrderTraversal(child);
        }
    }
    // post order traversal
    public static void postOrderTraversal(Node node) {
        // recursive
        for(Node child: node.children) {
            postOrderTraversal(child);
        }
        System.out.print(node.data + " ");
    }
    // iterative pre and post order traversals
    static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void iterativePreAndPostOrderTraversals(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        String pre = "";
        String post = "";
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            }
            else if(top.state == top.node.children.size()) {
                post += top.node.data + " ";
                st.pop();
            }
            else {
                Pair childPair = new Pair(top.node.children.get(top.state), -1);
                st.push(childPair);
                top.state++;
            }
        }
        System.out.println("PreOrder: " + pre);
        System.out.println("PostOrder: " + post);
    }

    // level order traversal
    public static void levelOrderTraversal(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        // rpa (remove, print, add child)
        while(q.size() > 0) {
            node = q.remove(); // remove
            System.out.print(node.data + " "); // print
            for(Node child: node.children) {
                q.add(child); // add
            }
        }
    }
    public static void levelOrderTraversalLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        while(mq.size() > 0) {
            node = mq.remove(); // remove from MAIN queue
            System.out.print(node.data + " "); // print
            for(Node child: node.children) {
                cq.add(child); // add in CHILD queue
            }
            if(mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println(" ");
            }
        }
    }
    public static void levelOrderTraversalLinewiseZigzag(Node node) {
        Stack<Node> ms = new Stack<>();
        ms.push(node);
        Stack<Node> cs = new Stack<>();
        int level = 1;
        while(ms.size() > 0) {
            node = ms.pop(); // remove
            System.out.print(node.data + " "); // print
            if(level % 2 == 1) {
                for(int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child); // add if odd
                }
            }
            else {
                for(int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child); // add if even
                }
            }
            if(ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println(" ");
            }
        }
    }

    // mirror image of generic tree
    public static void mirror(Node node) {
        for(Node child: node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    // remove all the leaf nodes (no children)
    public static void removeLeaves(Node node) {
        for(int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if(child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        for(Node child: node.children) {
            removeLeaves(child);
        }
    }

    // find given element in tree and return true or false
    public static boolean findElement(Node node, int key) {
        if(node.data == key) {
            return true;
        }
        for(Node child: node.children) {
            boolean findInChild = findElement(child, key);
            if(findInChild == true) {
                return true; // loop will not run anymore
            }
        }
        return false;
    }

    // display all elements in path from given node to root
    public static ArrayList<Integer> nodeToRootPath(Node node, int key) {
        if(node.data == key) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child: node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, key);
            if(pathTillChild.size() > 0) {
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>(); // empty list
    }

    // find lowest common ancestor of two given nodes (usually intersection point)
    public static int lowestCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }

    // find the distance between two given nodes (number of edges in between)
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        // found lowest common ancestor till this step
        return i + j; // sum of indexes is total sum of edges
    }

    // are trees similar in shape
    public static boolean areSimilarInShape(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if(!areSimilarInShape(c1, c2)) {
                return false;
            }
        }
        return true;
    }
    // are trees mirror in shape of each other
    public static boolean areMirrorInShape(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()) {
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n1.children.size() - i - 1);
            if(!areMirrorInShape(c1, c2)) {
                return false;
            }
        }
        return true;
    }
    // is a tree symmetric
    public static boolean isSymmetric(Node node) {
        return areMirrorInShape(node, node);
    }

    // multisolver to calculate size, min, max, height of tree by one function using global variables
    static int sizeGlobal;
    static int minGlobal;
    static int maxGlobal;
    static int heightGlobal;
    public static void multisolver(Node node, int depth) {
        sizeGlobal++;
        minGlobal = Math.min(minGlobal, node.data);
        maxGlobal = Math.max(maxGlobal, node.data);
        heightGlobal = depth + 1;
        for(Node child: node.children) {
            multisolver(child, depth + 1);
        }
    }

    // predecessor and successor of a given node
    static int predecessor;
    static int successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int key) {
        if(state == 0) {
            if(node.data == key) {
                state = 1;
            }
            else {
                predecessor = node.data;
            }
        }
        else if(state == 1) {
            successor = node.data;
            state = 2;
        }
        for(Node child: node.children) {
            predecessorAndSuccessor(child, key);
        }
    }

    // find ceiling and floor values of a given node
    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int key) {
        if(node.data >= key) {
            if(node.data <= ceil) {
                ceil = node.data;
            }
        }
        if(node.data <= key) {
            if(node.data >= floor) {
                floor = node.data;
            }
        }
        for(Node child: node.children) {
            ceilAndFloor(child, key);
        }
    }

    // find kth largest element in tree
    public static void findFloor(Node node, int key) {
        if(node.data < key) {
            floor = Math.max(floor, node.data);
        }
        for(Node child: node.children) {
            findFloor(child, key);
        }
    }
    public static int kthLargestElement(Node node, int k) {
        // O(k*n) time (by sir)
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            findFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
        // use priority queue for O(n*logk) time
    }

    // find the node which has maximum sum of it's subtree nodes
    static int maxSumNode;
    static int maxSum;
    public static int maximumSubtreeSum(Node node) {
        int sum = node.data;
        for(Node child: node.children) {
            sum += maximumSubtreeSum(child);
        }
        if(sum > maxSum) {
            maxSumNode = node.data;
            maxSum = sum;
        }
        return sum;
    }

    // diameter of generic tree (maximum number of edges between two nodes)
    static int diameter = 0;
    public static int diameterOfTree(Node node) {
        int dch = -1; // deepest child height
        int sdch = -1; // second deepest child height
        for(Node child: node.children) {
            int ch = diameterOfTree(child);
            if(ch > dch) {
                sdch = dch;
                dch = ch;
            }
            else if(ch > sdch) {
                sdch = ch;
            }
        }
        if(dch + sdch + 2 > diameter) {
            diameter = dch + sdch + 2;
        }
        dch++;
        return dch;
    }

    public static void main(String[] args) {
        Node root = null; // to create tree
        // constructors
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == -1) {
                st.pop();
            }
            else {
                Node t = new Node();
                t.data = arr[i];
                if(st.size() > 0) {
                    st.peek().children.add(t);
                }
                else {
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
        System.out.println(size(root));
        System.out.println(maximum(root));
        System.out.println(height(root));
        /*System.out.print("Pre-Order Traversal: ");
        preOrderTraversal(root);
        System.out.println(" ");
        System.out.print("Post-Order Traversal: ");
        postOrderTraversal(root);
        System.out.println(" ");
        System.out.print("Level-Order Traversal: ");
        levelOrderTraversal(root);
        System.out.println(" ");
        System.out.println("Level-Order Traversal Linewise: ");
        levelOrderTraversalLinewise(root);
        System.out.println("Level-Order Traversal Linewise ZigZag: ");
        levelOrderTraversalLinewiseZigzag(root);*/
        /*System.out.println("Mirror of tree: ");
        mirror(root);
        display(root);*/
        /*System.out.println("After removing leaves: ");
        removeLeaves(root);
        display(root);*/
        /*System.out.println(findElement(root, 110));
        System.out.println(findElement(root, 1100));*/
        /*System.out.println("Node To Root Path: ");
        System.out.println(nodeToRootPath(root, 110));*/
        /*System.out.println("Lowest Common Ancestor: ");
        System.out.println(lowestCommonAncestor(root, 70, 110));*/
        /*System.out.println("Distance between two nodes: ");
        System.out.println(distanceBetweenNodes(root, 70, 110));*/
        /*System.out.println("Are the given trees similar in shape? ");
        System.out.println(areSimilarInShape(root, root)); // add other trees to check
        System.out.println("Are the given trees mirror in shape? ");
        System.out.println(areMirrorInShape(root, root)); // add other trees to check
        System.out.println("Is the given tree symmetric in shape? ");
        System.out.println(isSymmetric(root));*/
        /*sizeGlobal = 0;
        minGlobal = Integer.MAX_VALUE;
        maxGlobal = Integer.MIN_VALUE;
        heightGlobal = 0;
        multisolver(root, heightGlobal);
        System.out.println(sizeGlobal);
        System.out.println(minGlobal);
        System.out.println(maxGlobal);
        System.out.println(heightGlobal);*/
        /*predecessor = -1;
        successor = -1;
        state = 0;
        predecessorAndSuccessor(root, 90);
        System.out.println(predecessor);
        System.out.println(successor);*/
        /*ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, 65);
        System.out.println(ceil);
        System.out.println(floor);*/
        /*System.out.println(kthLargestElement(root, 3));*/
        /*maxSumNode = 0;
        maxSum = Integer.MIN_VALUE;
        maximumSubtreeSum(root);
        System.out.println("For node, " + maxSumNode + " sum is: " + maxSum);*/
        /*diameterOfTree(root);
        System.out.println(diameter);*/
        /*iterativePreAndPostOrderTraversals(root);*/
    }
}
