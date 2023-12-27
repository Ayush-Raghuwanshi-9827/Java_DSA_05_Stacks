package Stacks;

import java.util.Stack;

public class PrintStackWithoutRemoving {
    public static void displayReverseElement(Stack<Integer> st){
        if (st.size() == 0) {
            return;
        }
        int x = st.pop();
        System.out.print(x + " ");
        displayReverseElement(st);
        st.push(x);
    }

     public static void displayElement(Stack<Integer> st){
        if (st.size() == 0) {
            return;
        }
        int x = st.pop();
        displayElement(st);
        System.out.print(x + " ");
        st.push(x);
    }

    
    public static void pushAtBottam(Stack<Integer> st, int num){
        if (st.size() == 0) {
            st.push(num);
            // System.out.print(st.peek() + " ");
            return;
        }
        int x = st.pop();
        pushAtBottam(st , num);
        // System.out.print(x + " ");
        st.push(x);
    }
    public static void reverseStackRecursion(Stack<Integer> sr){
        if(sr.size() == 1) return;
        int top = sr.pop();
        reverseStackRecursion(sr);
        pushAtBottam(sr, top);
    }
    public static void main(String[] args) {
         Stack<Integer> st = new Stack<>();
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);
        System.out.println(st);
        // int n = st.size();
        // int[] arr = new int[n];
        // for (int i = n - 1; i >= 0; i--) {
        //     arr[i] = st.pop();
        // }
        // for (int i = 0; i < n; i++) {
        //     System.out.print(arr[i] + " ");
        //     st.push(arr[i]);
        // }
        // System.out.println();
        // System.out.println(st);

        // Another approch with recurrsion
        //   displayReverseElement(st);
          System.out.println();
        //   displayElement(st);
          System.out.println();
        //   pushAtBottam(st);
        System.out.println(st);
        reverseStackRecursion(st);
        System.out.println(st);
    }
}
