package Stacks;

import java.util.Stack;

public class MaxAreaOfHistogram {
    public static int[] NextSmallerElement(int[] arr, int NextOrPrev){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        if(NextOrPrev == n-1){
        for(int i = n-1; i >= 0; i--){
            while(st.size() != 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                res[i] = n;
            }else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
        }else {
             for(int i = 0; i < n; i++){
            while(st.size() != 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                res[i] = n;
            }else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
        }
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int n = heights.length;
        int MaxArea = 0;
        int[] Next = NextSmallerElement(heights, n - 1);
        int[] Prev = NextSmallerElement(heights, 0);
        for(int i =0; i < n; i++){
            int ans = heights[i] * (Next[i] - Prev[i] - 1);
            if(ans > MaxArea){
                MaxArea = ans;
            }
        }
        System.out.println(MaxArea);
    }
}
