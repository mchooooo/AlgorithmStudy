package study_210518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1978 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] info = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(info[i]);
        }
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(check(arr[i])){
                answer.add(arr[i]);
            }
        }
        System.out.println(answer.size());

    }
    public static boolean check(int n){
        if(n==1) return false;
        if(n==2) return true;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
