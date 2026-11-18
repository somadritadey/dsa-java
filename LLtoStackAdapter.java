// create stack using linked list

import java.util.LinkedList;

public class LLtoStackAdapter {
    public static class LLToStackAdapter {
        LinkedList<Integer> list;
        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if(list.size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return list.removeFirst();
            }
        }

        int top() {
            if(list.size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) {
        LLToStackAdapter st = new LLToStackAdapter();
        st.push(10);
        st.push(20);
        st.push(30);
        st.pop();
        System.out.println(st.size());
        System.out.println(st.top());
    }
}
