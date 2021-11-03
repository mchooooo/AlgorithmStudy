package study_210704;

import java.util.Scanner;

public class BOJ_9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        char[] s  = new char[str1.length()+1];
        char[] t  = new char[str2.length()+1];
        for(int i = 0; i < str1.length(); i++){
            s[i+1] = str1.charAt(i);
        }
        for(int i = 0; i < str2.length(); i++){
            t[i+1] = str2.charAt(i);
        }
        /*
        *     A C A Y K P     C A P C A K
        *   C 0 1 1 1 1 1   A 0 1 1 1 1 1
        *   A 1 1 2 2 2 2   C 1 1 1 2 2 2
        *   P 1 1 2 2 2 3   A 1 2 2 2 3 3
        *   C 1 2 2 2 2 3   Y 1 2 2 2 3 3
        *   A 1 2 3 3 3 3   K 1 2 2 2 3 4
        *   K 1 2 3 3 4 4   P 1 2 3 3 3 4
        * */
        int[][] dp = new int[s.length][t.length];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s[i] == t[j]){ // A : C A P C A K
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        String ans = "";
        int comp = 0;
        for(int i = 0; i < dp[0].length; i++){
            if(comp != dp[i][dp[0].length-1]){

                ans += s[i];
                comp = dp[i][dp[0].length-1];
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
        if(dp[dp.length-1][dp[0].length-1] > 0) {
            System.out.println(ans);
        }
    }
}
