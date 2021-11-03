package study_210610;

import java.util.Scanner;

public class BOJ_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dist = new int[N-1];
        int[] price = new int[N];

        for( int i = 0; i < dist.length ;i++){
            dist[i] =sc.nextInt();
        }
        for(int i = 0; i < price.length; i++){
            price[i] = sc.nextInt();
        }

        long answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N-1; i++){
            if(min > price[i]){
                min = price[i];
            }else{
                price[i] = min;
            }
        }

        for(int i = 0; i < N-1; i++){
            answer += price[i] * dist[i];
        }
        System.out.println(answer);

    }
}
