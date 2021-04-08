package study_210408;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 1번 마을에서 최단거리 다익스트라로 구하고
* K보다 작게 걸리는 곳 카운트?
* */
public class Programmers_12978 {
    public static void main(String[] args){
        int N = 5;
        int K = 3;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

        //그래프 구성
        int[][] map = new int[N+1][N+1];
        //최단 거리 저장
        int[] dist = new int[N+1];

        //큰 값으로 미리 채움
        Arrays.fill(dist, 1000000);
        //중복된 길에 작은 값이 들어올 수 있도록 작은 값으로 채움
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                map[i][j] = 1000000;
            }
        }

        //그래프에 값 설정
        for(int i = 0; i < road.length; i++){//길이 여러개 들어올수있어서 N으로 하면 안됨;;
            int start = road[i][0];
            int end = road[i][1];
            int cost = road[i][2];
            System.out.print(start + " / "+ end +" / "+ cost);
            System.out.println();
            if(cost < map[start][end]){
                map[start][end] = map[end][start] = cost;
            }

        }


        //시작점 여기선 무적권 1번 ㅋㅋ
        int start = 1;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //시작점 0 으로
        dist[start] = 0;
        //pq에 시작점 넣기
        pq.add(new Edge(start, dist[start]));

        //우선순위 큐를 이용한 다익스트라
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            // 현재 값보다 작은 값이 있다면 패스
            if(edge.value > dist[edge.start]){
                continue;
            }

            for(int i = 1; i <= N; i++){

                if(map[edge.start][i] != 1000000){//경로가 존재하고
                    if(dist[i] > dist[edge.start] + map[edge.start][i]){ //저장 된 값이 계산된 값보다 작으면 갱신
                        dist[i] = dist[edge.start] + map[edge.start][i];
                        // pq에 넣음
                        pq.add(new Edge(i,dist[i]));
                    }
                }
            }

        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) answer++;
        }
        System.out.println(answer);


    }
}
class Edge implements Comparable<Edge>{
    int start;
    int value;

    public Edge(int start, int value){
        this.start =start;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e){
        return Integer.compare(this.value, e.value);
    }
}
