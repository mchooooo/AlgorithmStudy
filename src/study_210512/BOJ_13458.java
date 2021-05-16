package study_210512;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_13458 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] info = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(info[i]);
        }
        info = br.readLine().split(" ");
        int B = Integer.parseInt(info[0]);
        int C = Integer.parseInt(info[1]);

        long answer = 0;
        for(int i = 0; i < N; i++){
            long temp = A[i] - B;
            if(temp <= 0 ) continue;
            answer += (temp/C);
            if(temp % C != 0) answer++;
        }

        if(answer==0) System.out.println(1);
        else System.out.println(answer+N);

    }
}
