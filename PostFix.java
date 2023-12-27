package Stacks;

import java.util.Stack;


public class PostFix {
    public static String postfixToInfix(String str){
        Stack<String> st = new Stack<>();
        int n = str.length();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            int Ascii = (int)ch;
            if(Ascii <= 57 && Ascii >= 48){
                String t = "" + ch;
                st.push(t);
            }else {
                String v2 = st.pop();
                String v1 = st.pop();
                String t = "(" + v1 + ch + v2 + ")";
                st.push(t);
            }
        }
       return st.pop();
    }
    public static String ConversionPostfixExpressionToPrefixExpression(String str){
        Stack<String> st = new Stack<>();
        int n = str.length();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            int Ascii = (int)ch;
            if(Ascii <= 57 && Ascii >= 48){
                String t = "" + ch;
                st.push(t);
            }else {
                String v2 = st.pop();
                String v1 = st.pop();
                String t = ch + v1 + v2;
                st.push(t);
            }
        }
        String ans = st.pop();
        return ans;
    }

    public static int EvalutionOfPostfixExpression(String str){
      Stack<Integer> st = new Stack<>();
      for(int i=0; i < str.length(); i++){
        char c = str.charAt(i);
        int Ascii = (int) c;
        if(Ascii <= 57 && Ascii >= 48){
            st.push(Ascii - 48);
        }else{
            int v2 = st.pop();
            int v1 = st.pop();
            if(c == '+') st.push(v1 + v2);
            else if(c == '-') st.push(v1 - v2);
            else if(c == '*') st.push(v1 * v2);
            else  st.push(v1 / v2);
        }
      }
      int ans = st.pop();
      return ans;
    }
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            int Ascii = (int) c;
            if (Ascii >= 48 && Ascii <= 57) {
                String s = "" + c;
                val.push(s);
            } else if (op.size() == 0 || c == '(' || op.peek() == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char t = op.pop();
                    String v = v1 + v2 + t;
                    val.push(v);
                }
                op.pop();
            } else {
                if (c == '+' || c == '-') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char t = op.pop();
                    String v = v1 + v2 + t;
                    val.push(v);
                    op.push(c);
                }
                if (c == '*' || c == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char t = op.pop();
                        String v = v1 + v2 + t;
                        val.push(v);
                        op.push(c);
                    } else {
                        op.push(c);
                    }
                }
            }
        }
        while (val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char t = op.pop();
            String v = v1 + v2 + t;
            val.push(v);
        }
        String postFix = val.pop();
        System.out.println("Postfix : " + postFix);
        // Evalution of Postfix Expression - it means if a string is already a postfix
        // expression then you have to find answer and print that answer;

        // int Ans = EvalutionOfPostfixExpression(postFix);
        // System.out.println(Ans);

        // String ans = ConversionPostfixExpressionToPrefixExpression(postFix);
        // System.out.println("Prefix : " + ans);

        String ans = postfixToInfix(postFix);
        System.out.println("Infix : " + ans);
    }
}
