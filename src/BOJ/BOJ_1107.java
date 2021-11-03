package BOJ;

import java.util.Scanner;

public class BOJ_1107 {
    static int N;
    static boolean[] chk;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        //false = 고장 x, true = 고장
        chk = new boolean[10];
        for(int i = 0; i < M; i++){
            int temp = sc.nextInt();
            chk[temp] = true;
        }
        //+, - 버튼으로만 누른 경우
        int minCnt = Math.abs(N-100);
        for(int i = 0; i <= 1000000; i++){
            int len = findMin(i);
            if(len > 0){
                int press = Math.abs(N - i);
                minCnt = Math.min(minCnt, len + press);
            }
        }
        System.out.println(minCnt);

    }
    public static int findMin(int n){
        //채널 0인 경우
        if(n == 0){
            if(chk[0]) return 0;
            else return 1;
        }
        int len = 0;
        while(n > 0){
            //타겟 채널에서 고장난 버튼이 있으면 0 리턴
            if(chk[n%10]) return 0;
            //자릿수 줄이기
            n /= 10;
            //버튼 누르는 수 증가
            len += 1;
        }
        return len;
    }
}
