package study_210301;

import java.util.Scanner;

/*
* LCS문제 DP로 해결 가능
* 현재 위치에서 str1 == str2 -> dp[i][j] = dp[i-1][j-1]+1
*               str1 != str2 -> dp[i][j] = max(dp[i-1][j],dp[i][j-1])
* */
public class BOJ_9251 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] char1 = new char[str1.length()+1]; //7
        char[] char2 = new char[str2.length()+1]; //7
        int[][] dp = new int[char2.length][char1.length]; //7 * 7
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            char1[i+1] = ch;
        }
        for(int i = 0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            char2[i+1] = ch;
        }
//        System.out.println(char1[6]);
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(char1[j]==char2[i]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
//        for(int i = 1; i < dp.length; i++){
//            for(int j = 1; j < dp[0].length; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}
