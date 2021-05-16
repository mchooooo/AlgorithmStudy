package study_210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11057 {

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if( N == 1){
            System.out.println(10);
            System.exit(0);
        }

        find(N);

    }

    public static void find(int N){
        
    }
}
