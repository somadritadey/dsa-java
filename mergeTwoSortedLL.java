// merge two given sorted arrays

import java.util.Scanner;

public class mergeTwoSortedLL {
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
        public int size() {
            return size;
        }
        public void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println("");
        }
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

        // merge two sorted linked lists
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node one = l1.head;
            Node two = l2.head;
            LinkedList result = new LinkedList();
            while(one != null && two != null) {
                if(one.data < two.data) {
                    result.addLast(one.data);
                    one = one.next;
                }
                else {
                    result.addLast(two.data);
                    two = two.next;
                }
            }
            while(one != null) {
                result.addLast(one.data);
                one = one.next;
            }
            while(two != null) {
                result.addLast(two.data);
                two = two.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        System.out.println("Enter the number of elements in list 1: ");
        int n1 = scn.nextInt();
        System.out.println("Enter the number of elements in list 2: ");
        int n2 = scn.nextInt();
        System.out.println("Enter elements of list 1 in sorted manner: ");
        for(int i = 0; i < n1; i++) {
            int n = scn.nextInt();
            list1.addLast(n);
        }
        System.out.println("Enter elements of list 2 in sorted manner: ");
        for(int i = 0; i < n2; i++) {
            int n = scn.nextInt();
            list2.addLast(n);
        }

        LinkedList result = LinkedList.mergeTwoSortedLists(list1, list2); // class.function()
        System.out.println("Merged List is: ");
        result.display();
    }
}
