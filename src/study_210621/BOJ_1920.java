package study_210621;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i = 0; i < m; i++){
            target[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i = 0; i < m; i++){
            System.out.println(search(target[i]));
        }
    }

    public static int search(int x){
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(x == arr[mid]){
                return 1;
            }
            if(x < arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return 0;
    }

}
