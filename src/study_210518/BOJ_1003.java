package study_210518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1003 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i < 41; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        while(N-- > 0){
            int t = Integer.parseInt(br.readLine());
            if(t == 0) System.out.println(1+" "+0);
            else if(t == 1) System.out.println(0+" "+1);
            else System.out.println(dp[t-1] + " "+dp[t]);
        }

    }

}

