package Stacks;

import java.util.Stack;

public class Basics {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(44);
        System.out.println(st.peek());
        System.out.println(st);
        // Size of stacks
        System.out.println("Size : " +  st.size());
        // Print All the number in stack
        int size = st.size();
        for(int i = 0; i < size; i++){
            System.out.print(st.peek() + " ");
            st.pop();
        }
        System.out.println();
        // Check stack is empty or not ?
        System.out.println(st.isEmpty());
    }
}
