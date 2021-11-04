package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_17298 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[n];
//        int[] st = new int[n];
        boolean flag = false;
//        for(int i = 0; i < n; i++){
//            for(int j = i; j<n; j++){
//                int temp = arr[j];
//                if(arr[i] < temp){
//                    st.push(temp);
////                    st[i] = temp;
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag) st.push(-1);
//            flag = false;
//        }

        for(int i = n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < ans.length; i++){
            sb.append(ans[i]+" ");
        }

        System.out.print(sb.toString());

    }

}
