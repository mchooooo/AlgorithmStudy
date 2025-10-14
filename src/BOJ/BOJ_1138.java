package BOJ;

import java.util.Scanner;

public class BOJ_1138 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[n];
        boolean[] visit = new boolean[n];
        int temp = 0;
        int pos = 0;
        while (pos != ans.length) {
            for (int i = 0; i < n; i++) {
                if (!visit[arr[i]]) {
                    ans[arr[i]] = i + 1;
                    visit[arr[i]] = true;
                }
            }
            pos++;
//            int min = Integer.MAX_VALUE;
//            for(int i = 0; i < n; i++){
//                if(min > arr[i] && pos+1 <= min){
//                    min = arr[i];
//                    temp = i;
//
//                }
//            }
//            System.out.println("min="+min);
//            ans[pos] = temp+1;
//            arr[temp] = Integer.MAX_VALUE;
//            pos++;
//
        }
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }


    }
}
