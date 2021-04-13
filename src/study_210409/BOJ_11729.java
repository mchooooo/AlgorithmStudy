package study_210409;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* 하노이 타워
* 재귀를 통해 이동
* */
public class BOJ_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        hanoi(n,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);

    }

    /*
    * start = 출발지
    * mid = 경유지
    * to = 목적지
    * */
    public static void hanoi(int n, int start, int mid, int to){
        cnt++;
        // n이 1이되면, 원반이 한 개 남으면
        if (n == 1){
            // 출발지 도착지 출력
            sb.append(start + " " + to+ "\n");
            return;
        }
        // n-1 개 1번 기둥에서 2번 기둥으로 이동
        hanoi(n-1, start, to, mid);

        // 1개를 1번 기둥에서 3번 기둥으로 이동
        sb.append(start + " " + to + "\n");

        // n-1개 B에서 C로 이동
        hanoi(n-1, mid, start, to);
    }
}
