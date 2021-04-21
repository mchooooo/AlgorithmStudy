package study_210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 최소비용구하기
* 다익스트라
* */
class Edge implements Comparable<Edge>{
    int start;
    int value;
    public Edge(int start, int value){
        this.start = start;
        this.value = value;
    }
    @Override
    public int compareTo(Edge o){
        return this.value - o.value;
    }
}
public class BOJ_1916 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++){
            String[] sp = br.readLine().split(" ");
            int start = Integer.parseInt(sp[0]);
            int end = Integer.parseInt(sp[1]);
            int value = Integer.parseInt(sp[2]);
            if(value < map[start][end]) {
                map[start][end] = value;
            }
        }

        String[] sp = br.readLine().split(" ");
        int start = Integer.parseInt(sp[0]);
        int end = Integer.parseInt(sp[1]);

        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // 시작점은 0으로 초기화
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start,dist[start]));
        //우선순위 큐를 이용한 다익스트라
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            // 현재값보다 작다면 패스
            if(edge.value > dist[edge.start]) continue;
            for(int i = 1; i <= N; i++){
                if(map[edge.start][i] != Integer.MAX_VALUE){//경로가 존재하고
                    if(dist[i] > dist[edge.start] + map[edge.start][i]){ //저장 된 값이 계산된 값보다 작으면 갱신
                        dist[i] = dist[edge.start] + map[edge.start][i];
                        // pq에 넣음
                        pq.add(new Edge(i,dist[i]));
                    }
                }
            }
        }

        System.out.println(dist[end]);

    }
}


