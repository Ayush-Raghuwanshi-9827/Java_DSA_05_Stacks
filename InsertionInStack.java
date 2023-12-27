package Stacks;

import java.util.Stack;

public class InsertionInStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(44);
        System.out.println(st);
        int idx = 2;
        int el = 7;
        Stack<Integer> temp = new Stack<>();
        while (st.size() > idx) {
            temp.push(st.pop());
        }
        st.push(el);
        while (temp.size() > 0) {
            st.push(temp.pop());
        }
        System.out.println(st);
    }
}
