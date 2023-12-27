package Stacks;

import java.util.Stack;

public class Infix {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        int n = str.length();
        for(int i =0; i < n; i++){
            char x = str.charAt(i);
            int ascii = (int) x;
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            }else if(op.size() == 0 || x == '(' || op.peek() == '(') op.push(x);
            else if (x ==')') {
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1 + v2);
                    if(op.peek() == '-') val.push(v1 - v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                    if(op.peek() == '*') val.push(v1 * v2);
                    op.pop();
                }
                op.pop();
            }
            else {
                if(x == '+' || x == '-'){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '+') val.push(v1 + v2);
                    if(op.peek() == '-') val.push(v1 - v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                    if(op.peek() == '*') val.push(v1 * v2);
                    op.pop();
                    op.push(x);
                }
                if (x == '*' || x == '/') {
                    if(op.peek() == '*' || op.peek() == '/'){
                       int v2 = val.pop();
                       int v1 = val.pop();
                       if(op.peek() == '/') val.push(v1 / v2);
                       if(op.peek() == '*') val.push(v1 * v2);
                       op.pop();
                       op.push(x);
                    }else {
                        op.push(x);
                    }
                }
            }
        }
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
             if (op.peek() == '+') val.push(v1 + v2);
             if(op.peek() == '-') val.push(v1 - v2);
             if(op.peek() == '/') val.push(v1 / v2);
            if(op.peek() == '*') val.push(v1 * v2);
            op.pop();
        }
        System.out.println(val.peek());
    }
}
