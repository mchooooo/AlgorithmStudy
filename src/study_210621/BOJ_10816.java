package study_210621;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_10816 {
    static int n;
    static int[] arr2;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] target = new int[m];
        for(int i = 0; i < m; i++){
            target[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            System.out.println(searchLow(target[i]));
        }
        System.out.println(sb.toString());
    }
    public static int searchLow(int x){
        int left = 0;
        int right = n-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < x) left = mid+1;
            else if(arr[mid] > x) right = mid;
            else return mid;
        }

        return right;

    }
    public static int searchHigh(int x){
        return 0;
    }
}
