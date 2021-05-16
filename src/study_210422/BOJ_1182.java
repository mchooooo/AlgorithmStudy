package study_210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* 재귀를 사용해서
* 1. i번째 인덱스의 요소를 더하는 경우
* 2. 더하지 않는 경우로 나눠서 탐색
* */
public class BOJ_1182 {
    static int[] arr;
    static int target;
    static int N;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        target = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        dfs(0,0);
        System.out.println(count);

    }
    public static void dfs(int num,int idx){
        if(idx == N) return;
        if(num+arr[idx] == target){
            count++;
        }
        dfs(num, idx+1);
        dfs(num+arr[idx], idx+1);
    }
}
