package study_210518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
* 치킨배달 다시 풀어보기
* */
public class BOJ_15686 {
    static List<Node> chicken = new ArrayList<>();
    static List<Node> house = new ArrayList<>();
    static boolean[] check;
    static int M;
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        int[][] map = new int[N+1][N+1];
        for(int i = 0; i < N; i++){
            info = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int n = Integer.parseInt(info[j]);
                if(n == 1) house.add(new Node(i,j));
                else if(n == 2) chicken.add(new Node(i,j));
            }
        }
        //치킨집을 고르기 위한 boolean배열 필요
        check = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int start,int cnt){
        if(cnt == M){
            // 고른 치킨집에서 치킨 거리 계산
            int result = 0;
            for(int i = 0; i < house.size(); i++){
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if(check[j]){
                        //선택된 치킨집 에서 골라야 함
                        //집 하나 고르고 가장 가까운 치킨집 고름
                        int dist = dist(house.get(i), chicken.get(j));
                        temp = Math.min(dist,temp);
                    }
                }
                result += temp;
            }
            answer = Math.min(result,answer);
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            check[i] = true;
            dfs(i+1, cnt+1);
            check[i] = false;
        }
    }
    public static int dist(Node a, Node b){
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
