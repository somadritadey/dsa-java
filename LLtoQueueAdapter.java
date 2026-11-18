// create queue using linked list

import java.util.LinkedList;

public class LLtoQueueAdapter {
    public static class LLToQueueAdapter {
        LinkedList<Integer> list;
        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if(list.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                return list.removeFirst();
            }
        }

        int peek() {
            if(list.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) {
        LLToQueueAdapter queue = new LLToQueueAdapter();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.remove();
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}
