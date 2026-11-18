// implement a median priority queue such that it's highest priority is it's lowest median

import java.util.Collections;
import java.util.PriorityQueue;

public class medianPriorityQueue {
    public static class medianPQ {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public medianPQ() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if(right.size() > 0 && val > right.peek()) {
                right.add(val);
            }
            else {
                left.add(val);
            }
            if(left.size() - right.size() == 2) {
                right.add(left.remove());
            }
            else if(right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size() >= right.size()) {
                return left.remove();
            }
            else {
                return right.remove();
            }
        }

        public int peek() {
            if(this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if(left.size() >= right.size()) {
                return left.peek();
            }
            else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }
    }
    
    public static void main(String[] args) {
        medianPQ pq = new medianPQ();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);
        pq.add(60);
        System.out.println(pq.peek());
    }
}
