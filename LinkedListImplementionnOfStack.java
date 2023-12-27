package Stacks;

public class LinkedListImplementionnOfStack {
    public static class Node {
       int val;
       Node next;
       Node(int val){
        this.val = val;
       }
    }
    public static class Stack {
      Node head = null;
      int size = 0;
      void push(int x){
         Node temp = new Node(x);
         temp.next = head;
         head = temp;
         size++;
      }
      void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        return;
      }
      int Size(){
        return size;
      }
      int peek(){
        if (head == null) {
            System.out.println("Empty Stack");
            return -1;
        }
        return head.val;
      }
      int pop(){
        if (head == null) {
            System.out.println("Empty Stack");
            return -1;
        }
        int x = head.val;
        head = head.next;
        size--;
        return x;
      }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.Size());
        st.display();
        System.out.println(st.peek());
        st.pop();
        st.display();
        System.out.println(st.Size());
    }
}
