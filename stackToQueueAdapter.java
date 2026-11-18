// implement queue using stacks

import java.util.Stack;

public class stackToQueueAdapter {
    // remove efficient (in o(1) complexity)
    /*public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            int s1 = mainS.size();
            for(int i = 0; i < s1; i++) {
                int num = mainS.pop();
                helperS.push(num);
            }
            mainS.push(val);
            int s2 = helperS.size();
            for(int i = 0; i < s2; i++) {
                int num = helperS.pop();
                mainS.push(num);
            }
        }

        int remove() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                return mainS.pop();
            }
        }

        int peek() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                return mainS.peek();
            }
        }
    }*/

    // add efficient (in o(1) complexity)
    /*public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                int s1 = mainS.size();
                for(int i = 0; i < s1 - 1; i++) {
                    int num = mainS.pop();
                    helperS.push(num);
                }
                int val = mainS.pop();
                int s2 = helperS.size();
                for(int i = 0; i < s2; i++) {
                    int num = helperS.pop();
                    mainS.push(num);
                }
                return val;
            }
        }

        int peek() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            else {
                int s1 = mainS.size();
                for(int i = 0; i < s1 - 1; i++) {
                    int num = mainS.pop();
                    helperS.push(num);
                }
                int val = mainS.peek();
                int s2 = helperS.size();
                for(int i = 0; i < s2; i++) {
                    int num = helperS.pop();
                    mainS.push(num);
                }
                return val;
            }
        }
    }*/

    public static void main(String[] args) {
        /*StackToQueueAdapter st = new StackToQueueAdapter();
        st.add(10);
        st.add(20);
        st.add(30);
        st.add(40);
        st.add(50);
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.remove());
        System.out.println(st.peek());*/
    }
}
