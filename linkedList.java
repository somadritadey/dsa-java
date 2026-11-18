// linked list implementation using node class
// includes size, print, add, remove, get
// imp: reverse, display reverse (recursive data ptr), kth from last, middle
// imp: palindrome, fold list, add lists, intersection point

public class linkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;
        public LinkedList() {
            head = tail = null;
            size = 0;
        }

        // size
        public int size() {
            return size;
        }

        // print
        public void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("");
        }

        // add
        public void addFirst(int val) {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            if(size == 0) {
                tail = temp;
            }
            size++;
        }
        public void addLast(int val) {
            Node temp = new Node(val);
            if(size == 0) {
                head = tail = temp;
            }
            else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        public void addAt(int idx, int val) {
            if(idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            }
            else if(idx == 0) {
                addFirst(val);
            }
            else if(idx == size) {
                addLast(val);
            }
            else {
                Node node = new Node(val);
                Node temp = head;
                for(int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        // remove
        public int removeFirst() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            else if(size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            else {
                int val = head.data;
                head = head.next;
                size--;
                return val;
            }
        }
        public int removeLast() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            else if(size == 1) {
                int val = tail.data;
                head = tail = null;
                size = 0;
                return val;
            }
            else {
                Node temp = head;
                for(int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                int val = temp.next.data;
                tail = temp;
                temp.next = null;
                size--;
                return val;
            }
        }
        public int removeAt(int idx) {
            if(idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
                return -1;
            }
            else if(idx == 0) {
                return removeFirst();
            }
            else if(idx == size) {
                return removeLast();
            }
            else {
                Node temp = head;
                for(int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                Node deletedNode = temp.next;
                int val = deletedNode.data;
                temp.next = deletedNode.next;
                deletedNode.next = null;
                size--;
                return val;
            }
        }

        // get
        public int getFirst() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            else {
                return head.data;
            }
        }
        public int getLast() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            else {
                return tail.data;
            }
        }
        public int getAt(int idx) {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            else if(idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            }
            else {
                Node temp = head;
                for(int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for(int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
        // reverse iterative
        public void reverseDI() {
            // data iterative
            int li = 0;
            int ri = size - 1;
            while(li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                // swap
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                li++;
                ri--;
            }
        }
        public void reversePI() {
            // pointer iterative
            Node prev = null;
            Node current = head;
            while(current != null) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            // swap head tail
            Node temp = head;
            head = tail;
            tail = temp;
        }

        private void displayReverseHelper(Node node) {
            if(node == null) {
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }
        private void reverseDRHelper(Node right, int floor) {
            if(right == null) {
                return;
            }
            reverseDRHelper(right.next, floor + 1);
            if(floor >= size / 2) {
                int temp = right.data;
                right.data = left.data;
                left.data = temp;
                left = left.next;
            }
        }
        private void reversePRHelper(Node node) {
            if(node == null) {
                return;
            }
            reversePRHelper(node.next);
            if(node == tail) {
                // do nothing
            }
            else {
                node.next.next = node;
            }
        }
        // recursive reverse
        public void displayReverse() {
            // display reverse
            displayReverseHelper(head);
            System.out.println("");
        }
        Node left;
        public void reverseDR() {
            // data recursive
            left = head;
            reverseDRHelper(head, 0);
        }
        public void reversePR() {
            // pointer recursive
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }

        // kth from last
        public int kthFromLast(int k) {
            Node s = head; // slow
            Node f = head; // fast
            for(int i = 0; i < k; i++) {
                f = f.next;
            }
            while(f != tail) {
                s = s.next;
                f = f.next;
            }
            return s.data;
        }

        // middle node of linked list
        public int mid() {
            Node s = head; // slow
            Node f = head; // fast
            while(f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
            }
            return s.data;
        }

        private boolean isPalindromeHelper(Node pright) {
            if(pright == null) {
                return true;
            }
            boolean res = isPalindromeHelper(pright.next);
            if(res == false) { // this step is to bring pointer from null to last node
                return false;
            }
            else if(pleft.data != pright.data) {
                return false;
            }
            else {
                pleft = pleft.next;
                return true;
            }
        }
        // is linked list a palindrome
        Node pleft;
        public boolean isPalindrome() {
            pleft = head;
            return isPalindromeHelper(head);
        }

        private void foldHelper(Node fright, int floor) {
            if(fright == null) {
                return;
            }
            foldHelper(fright.next, floor + 1);
            if(floor > size / 2) {
                Node temp = fleft.next;
                fleft.next = fright;
                fright.next = temp;
                fleft = temp;
            }
            else if(floor == size / 2) {
                tail = fright;
                tail.next = null;
            }
        }
        // fold a linked list
        Node fleft;
        public void fold() {
            fleft = head;
            foldHelper(head, 0);
        }

        public static int addTwoLinkedListsHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            if(one == null && two == null) {
                return 0;
            }
            int data = 0;
            if(pv1 > pv2) {
                int oc = addTwoLinkedListsHelper(one.next, pv1 - 1, two, pv2, res);
                data = one.data + oc;
            }
            else if(pv1 < pv2) {
                int oc = addTwoLinkedListsHelper(one, pv1, two.next, pv2 - 1, res);
                data = two.data + oc;
            }
            else {
                int oc = addTwoLinkedListsHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
                data = one.data + two.data + oc;
            }
            int newData = data % 10;
            int nc = data / 10;
            res.addFirst(newData);
            return nc;
        }
        // add two linked lists
        public static LinkedList addTwoLinkedLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int oc = addTwoLinkedListsHelper(one.head, one.size(), two.head, two.size(), res);
            if(oc > 0) {
                res.addFirst(oc);
            }
            return res;
        }

        // intersection point of two lists
        public static int findIntersection(LinkedList one, LinkedList two) {
            Node t1 = one.head;
            Node t2 = two.head;
            int delta = Math.abs(one.size - two.size);
            if(one.size > two.size) {
                for(int i = 0; i < delta; i++) {
                    t1 = t1.next;
                }
            }
            else {
                for(int i = 0; i < delta; i++) {
                    t2 = t2.next;
                }
            }
            while(t1 != null && t2 != null) {
                if(t1.data == t2.data) {
                    return t1.data;
                }
                t1 = t1.next;
                t2 = t2.next;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // do any operations
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.display();
        System.out.println(list.size());
        list.removeAt(1);
        list.display();
        list.reverseDI();
        list.display();
        list.reversePI();
        list.display();
        System.out.println(list.kthFromLast(1));
        System.out.println(list.mid());
        list.displayReverse();
        list.display();
        list.reversePR();
        list.display();
        list.reverseDR();
        list.display();
        list.removeLast();
        list.removeFirst();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        System.out.println(list.isPalindrome());
        list.removeLast();
        System.out.println(list.isPalindrome());
        list.removeLast();
        list.removeLast();
        list.removeFirst();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.fold();
        list.display();
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.addFirst(9);
        l1.addLast(7);
        l1.addLast(8);
        l1.addLast(5);
        l2.addFirst(4);
        l2.addLast(6);
        LinkedList res = LinkedList.addTwoLinkedLists(l1, l2);
        res.display();
        LinkedList l3 = new LinkedList();
        LinkedList l4 = new LinkedList();
        l3.addFirst(0);
        l3.addLast(1);
        l3.addLast(2);
        l3.addLast(3);
        l3.addLast(4);
        l3.addLast(5);
        l3.addLast(6);
        l4.addFirst(8);
        l4.addLast(7);
        l4.addLast(4);
        l4.addLast(5);
        l4.addLast(6);
        int intersection = LinkedList.findIntersection(l3, l4);
        System.out.println(intersection);
    }
}
