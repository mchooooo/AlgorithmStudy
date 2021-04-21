package study_210420;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1138 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> list  = new ArrayList<>();

        for(int i = arr.length - 1; i >= 0; i--){
            list.add(arr[i],i+1);
        }
        for(int i : list){
            System.out.print(i + " ");
        }

    }
}
