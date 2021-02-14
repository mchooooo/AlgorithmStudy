package study_210214;

import java.util.Scanner;

public class BOJ_9663 {

    static int cnt = 0;
    static int n;
    static int[] board;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        nqueen(0);
        System.out.println(cnt);

    }
    public static void nqueen(int idx){
        if(idx == n){
            cnt++;
            return;
        }
        for(int i = 0; i < n; i++){
            board[idx] = i;
            if(check(idx)){
                nqueen(idx+1);
            }
        }
    }
    public static boolean check(int idx){
        for(int i = 0; i < idx;i++){
            //같은 열 || 대각선이면 안됨(행의 차이와 열의 차이가 같다면 대각선에 있다.)
            if(board[idx]==board[i] || idx - i == Math.abs(board[idx] - board[i])){
                return false;
            }
        }
        return true;
    }
}
