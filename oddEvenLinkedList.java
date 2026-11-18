// create odd even list, such that odd numbers are followed by even numbers, in same order

import java.util.Scanner;

public class oddEvenLinkedList {
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

        // odd even linked list
        public void oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while(this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();
                if(val % 2 == 0) {
                    even.addLast(val);
                }
                else {
                    odd.addLast(val);
                }
            }
            if(odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }
            else if(odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the elements of list: ");
        for(int i = 0; i < n; i++) {
            int num = scn.nextInt();
            list.addLast(num);
        }

        System.out.println("Odd Even list is: ");
        list.oddEven();
        list.display();
    }
}
