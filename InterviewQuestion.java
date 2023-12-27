package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class InterviewQuestion {
    public static Boolean checkBalanced(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                }
                if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        if (st.size() > 0) {
            return false;
        }
        return true;
    }

    public static int MinNumOfBracketToBlancedTheString(String str) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    count++;
                } else {
                    st.pop();
                }
            }
        }
        if (st.size() > 0) {
            return st.size() + count;
        }
        return count;
    }

    public static int[] remove_Consecutive_SubSequence(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0; i < n; i++){
            if(st.size() == 0 || st.peek() != arr[i]) st.push(arr[i]);
            else if (arr[i] == st.peek()) {
                if (i == n-1 || arr[i] != arr[i+1]) {
                    st.pop();
                }   
            }
        }
          int[] res = new int[st.size()];
          for(int j = res.length - 1; j >= 0; j--){
            res[j] = st.pop();
          }
        return res;
    }
    public static int[] next_Greater_Element(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = -1;
        st.push(arr[n -1]);
        for(int i = n-2; i >= 0; i--){
            while (st.size() > 0 && st.peek() < arr[i] ) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;

    }
    public static int[] calculateSpan(int price[], int n){
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = 1;
        st.push(0);
        for(int i=1; i < n; i++){
            while(st.size() > 0 && price[i] > price[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                res[i] = i+1;
                st.push(i);
            }else{
               res[i] = i - st.peek();
               st.push(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // System.out.println(checkBalanced(str));
        // System.out.println(MinNumOfBracketToBlancedTheString(str));
        // int[] arr = {1,3,2,1,8,6,3,4};
        // int[] res = remove_Consecutive_SubSequence(arr);
        // System.out.println(Arrays.toString(res)); 
        // int[] res = next_Greater_Element(arr);
        // System.out.println(Arrays.toString(res));
        int[] arr = {100,80,60,70,60,75,85};
        int[] res = calculateSpan(arr,7);
        System.out.println(Arrays.toString(res));
    }
}
