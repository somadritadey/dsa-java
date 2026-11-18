// implement stack using queues

import java.util.ArrayDeque;
import java.util.Queue;

public class queueToStackAdapter {
    // pop efficient (in o(1) complexity)
    /*public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;
        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            int s1 = mainQ.size();
            for(int i = 0; i < s1; i++) {
                int num = mainQ.remove();
                helperQ.add(num);
            }
            mainQ.add(val);
            int s2 = helperQ.size();
            for(int i = 0; i < s2; i++) {
                int num = helperQ.remove();
                mainQ.add(num);
            }
        }

        int pop() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return mainQ.remove();
            }
        }

        int top() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return mainQ.peek();
            }
        }
    }*/

    // push efficient (in o(1) complexity)
    /*public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;
        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int s1 = mainQ.size();
                for(int i = 0; i < s1 - 1; i++) {
                    int num = mainQ.remove();
                    helperQ.add(num);
                }
                int val = mainQ.remove();
                int s2 = helperQ.size();
                for(int i = 0; i < s2; i++) {
                    int num = helperQ.remove();
                    mainQ.add(num);
                }
                return val;
            }
        }

        int top() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int s1 = mainQ.size();
                for(int i = 0; i < s1 - 1; i++) {
                    int num = mainQ.remove();
                    helperQ.add(num);
                }
                int val = mainQ.remove();
                helperQ.add(val);
                int s2 = helperQ.size();
                for(int i = 0; i < s2; i++) {
                    int num = helperQ.remove();
                    mainQ.add(num);
                }
                return val;
            }
        }
    }*/

    public static void main(String[] args) {
        /*QueueToStackAdapter st = new QueueToStackAdapter();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st.size());
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());*/
    }
}
