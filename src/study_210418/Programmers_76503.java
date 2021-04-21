package study_210418;

import java.util.ArrayList;
import java.util.List;

/*
* 모두 0으로 만들기
* 리스트 배열로 트리 만들고
* dfs로 0만들기 ㅋㅋ
* */
public class Programmers_76503 {

    static List<Integer>[] list;
    static long result;
    static long[] long_a;

    public static void main(String[] args){

        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        long_a = new long[a.length];
        list = new List[a.length];
        long sum = 0;
        for(int i = 0; i < a.length ; i++){
            list[i] = new ArrayList<>();
            long_a[i] = a[i];
            sum += a[i];
        }
//        if(sum != 0) return;

        for(int[] edge : edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        dfs(0,0);
        System.out.println(result);
    }

    public static void dfs(int cur, int par){

        for(int next : list[cur]){
            System.out.println(cur + " / " + par + " / "+ next);
            if(next != par){
                dfs(next, cur);
            }
        }
        long_a[par] += long_a[cur];
        result += Math.abs(long_a[cur]);

    }

}
