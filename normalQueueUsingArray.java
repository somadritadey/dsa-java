// build a normal static queue using array and make it like Queue class

import java.util.Scanner;

public class normalQueueUsingArray {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int n) {
            data = new int[n];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for(int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println("");
        }

        void add(int val) {
            if(size == data.length) {
                System.out.println("Queue Overflow");
            }
            else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if(size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if(size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                return data[front];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter maximum size of queue: ");
        int n = scn.nextInt();
        CustomQueue queue = new CustomQueue(n);

        // do any operations
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.display();
        queue.remove();
        queue.remove();
        System.out.println(queue.size());
        queue.add(60);
        queue.add(70);
        queue.display();
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}
