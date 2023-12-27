package Stacks;

import java.util.Stack;

public class Prefix {

    public static String PrefixToInfix(String str){
        Stack<String> st = new Stack<>();
        int n = str.length();
        for(int i= n-1; i >= 0; i--){
            char s = str.charAt(i);
            int Ascii = (int)s;
            if(Ascii <= 57 && Ascii >= 48){
                String t = "" + s;
                st.push(t);
            }else {
               String v1 = st.pop();
               String v2 = st.pop();
               String t = "(" + v1 + s + v2 + ")";
               st.push(t);
            }
        }
        String ans = "Infix : " + st.pop();
        return ans;
    }
    // " -9/*+5346 " */
    public static int EvalutionOfPrefixExpression(String str) {
        Stack<Integer> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int Ascii = (int) c;
            if (Ascii <= 57 && Ascii >= 48) {
                st.push(Ascii - 48);
            } else {
                int v2 = st.pop();
                int v1 = st.pop();
                if (c == '+')
                    st.push(v2 + v1);
                else if (c == '-')
                    st.push(v2 - v1);
                else if (c == '*')
                    st.push(v2 * v1);
                else
                    st.push(v2 / v1);
            }
        }
        int ans = st.pop();
        return ans;
    }

    public static String ConversionPrefixExpressionToPostfixExpression(String str){
        Stack<String> st = new Stack<>();
        int n = str.length();
        for(int i= n-1; i >= 0; i--){
            char s = str.charAt(i);
            int Ascii = (int)s;
            if(Ascii <= 57 && Ascii >= 48){
                String t = "" + s;
                st.push(t);
            }else {
               String v1 = st.pop();
               String v2 = st.pop();
               String t = v1 + v2 + s;
               st.push(t);
            }
        }
        String ans = "Postfix : " + st.pop();
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
                    String v = t + v1 + v2;
                    val.push(v);
                }
                op.pop();
            } else {
                if (c == '+' || c == '-') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char t = op.pop();
                    String v = t + v1 + v2;
                    val.push(v);
                    op.push(c);
                }
                if (c == '*' || c == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char t = op.pop();
                        String v = t + v1 + v2;
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
            String v = t + v1 + v2;
            val.push(v);
        }
        String prefix = val.pop();
        System.out.println("Prefix : " + prefix);
        //  // Evalution of prefix Expression - it means if a string is already a prefix
        // expression then you have to find answer and print that answer;
        // 
        // 
         String Infix = PrefixToInfix(prefix);
         System.out.println(Infix);
    }
}
