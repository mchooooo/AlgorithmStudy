package study_210301;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
/*
* 일반 배열을 이용한 다익스트라
* 메모리초과
* */
public class BOJ_1753_2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int startPos = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[V+1][V+1];
        for(int i = 0; i <E; i++){
            arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        int[] D = new int[V+1];
        boolean[] checked = new boolean[V+1];
        Arrays.fill(D,Integer.MAX_VALUE);
        D[startPos] = 0;
        StringBuilder sb = new StringBuilder();
        //다익스트라
        for(int i = 1; i < V; i++){
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int j = 1; j <= V; j++){
                //아직 처리하지 않고 가장 짧은 거리라면
                if(!checked[j]&& min > D[j]){
                    idx = j;
                    min = D[j];
                }
            }

            for(int j = 1; j <= V; j++){
                //아직 처리x, 경로 존재, idx까지 거리 + (idx+j)까지의 거리가 D[j]보다 작다면
                if(!checked[j] && arr[idx][j] != 0 && D[idx] != Integer.MAX_VALUE && D[idx]+arr[idx][j] < D[j]){
                    D[j] = D[idx] + arr[idx][j];
                }
            }
            checked[idx] = true;
        }
        for(int i = 1; i <= V; i++){
            if(D[i]==Integer.MAX_VALUE){
                sb.append("INF"+"\n");
            }else{
                sb.append(D[i]+"\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
