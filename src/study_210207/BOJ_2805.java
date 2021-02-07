package study_210207;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2805 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] trees = new int[n];
        for(int i = 0; i < n; i++){
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);

        long left = 0;
        long right = trees[n-1];//20
        long result = 0;
        long mid = 0;
        while(left <= right){
            result=0;
            mid = (left+right)/2; //10 , 15

            for(int i = 0; i < n; i++){
                if(trees[i] > mid){
                    result+= trees[i]-mid;
                }
            }
            //result = 5+7+10 = 23 / 2 + 5 = 7
            if(result >= m){ //23 >= 7 , 7=7
                left = mid+1; //11 , 12
            }else{
                right = mid-1;
            }
        }
        System.out.println(right);



    }
}
