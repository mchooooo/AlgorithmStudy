package study_210523;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10819 {
    static int n;
    static int[] arr;
    static int answer = 0;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new boolean[n];
        String[] info = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(info[i]);
        }

        max(0,0);
        System.out.println(answer);

    }
    public static void max(int cnt,int cal){
        if(cnt == arr.length){
            answer = Math.max(answer, cal);
//            System.out.println(answer);
            return;
        }
//        System.out.println(cal);
        for(int i = 0; i < arr.length; i++){
            check[i] = true;
            max(cnt+1, Math.abs(cal-arr[i]));
            check[i] = false;
        }
    }
}
