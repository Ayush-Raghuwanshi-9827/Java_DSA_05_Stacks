package Stacks;

public class ArrayImplementationOfStack {
    public static class Stack {
        int[] arr = new int[50];
        int idx = 0;
         void push(int x){
            if (isFull()) {
                System.out.println("Stack is Full");
                return;
            }
            arr[idx] = x;
            idx++;
            return;
        }
        void display(){
           for(int i = 0; i < idx; i++){
            System.out.print(arr[i] + " ");
           }
           System.out.println();
        }
         int size(){
            return idx;
        }
        int peek(){
            if(idx == 0){
                System.out.println("Empty Stack");
                return -1;
            }
            return arr[idx -1];
        }
        int pop(){
            if(idx == 0) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = arr[idx -1];
            arr[idx - 1] = 0;
            idx--;
            return top;
        }
        Boolean isEmpty(){
            if (idx == 0) {
                return true;
            }
            return false;
        }
        Boolean isFull(){
            if (idx == arr.length) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
       Stack st = new Stack();
       st.push(1);
       st.push(2);
       st.push(3);
       st.push(4);
       st.push(5);
       int x = st.size();
       System.out.println(x);
       st.display();
       st.pop();
       st.display();
       System.out.println(st.peek());

    }
}
