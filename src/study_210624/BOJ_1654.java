package study_210624;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        long min = 1;
        long max = arr[n-1];
        long answer = 0;
        while(min <= max){
            long mid = min + (max - min) / 2;
            long cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += arr[i] / mid;
            }
            if(cnt >= k) { //mid 값으로 잘랐더니, 랜선 개수가 목표값보다 크거나 같다 --> 더 크게 자른다
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        System.out.println(max);

    }
}
