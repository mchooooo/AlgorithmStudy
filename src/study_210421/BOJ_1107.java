package study_210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1107 {
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        check = new boolean[10];

        if(M != 0) {
            String[] sp = br.readLine().split(" ");

            for (int i = 0; i < sp.length; i++) {
                int broken = Integer.parseInt(sp[i]);
                check[broken] = true;
            }
        }


        int min_cnt = Math.abs(N - 100);    // +,- 로만 누르는 경우
        for (int i = 0; i <= 500000; i++) {
            int len = findNum(i);   // 숫자버튼 누르는 횟수
            if (len > 0) {
                int press = Math.abs(N - i);  // +,- 버튼 누르는 횟수
                min_cnt = Math.min(min_cnt, len + press);   // 최소 이동 횟수 계산
            }
        }
        System.out.println(min_cnt);

//        for(int i = 0; i < N.length(); i++){
//            char ch = N.charAt(i);
//            if(check[Integer.parseInt(ch+"")]) tempChannel += (ch+"");
//            else{
//                String find = findNum(ch,check);
//                tempChannel += find;
//            }
//        }


    }
    public static int findNum(int n){
        if (n == 0) {
            if (check[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (n > 0) {
            if (check[n % 10]) {   // 고장난 버튼이 있는 경우
                return 0;
            }
            n /= 10;
            len += 1;   // 숫자버튼 누르는 횟수 증가
        }
        return len;
    }
}
