package Stacks;

// import java.util.Scanner;
import java.util.Stack;

public class MoveStackInSameOrder {
    public static void main(String[] args) {
            // Scanner sc = new Scanner(System.in);
            Stack<Integer> st = new Stack<>();
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);

            // System.out.println(st);
            // // new stack 
            Stack<Integer> tempStack = new Stack<>();
            // while(st.size() > 0) {
            //     tempStack.push(st.pop());
            // }
            // System.out.println(tempStack);
            // Stack<Integer> copy = new Stack<>();
            // while (tempStack.size() > 0) {
            //     copy.push(tempStack.pop());
            // }
           
            // System.out.println(copy);

            // Insert at bottom / any index
            // insert 7 at bootom
            System.out.println(st);
             while (st.size() > 0) {
                tempStack.push(st.pop());
             }
             st.push(7);
             while (tempStack.size() > 0) {
                st.push(tempStack.pop());
             }
             System.out.println(st);

        }
}
