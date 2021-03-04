package study_210301;

import java.util.*;

public class BOJ_1753_3 {
    static int INF = 100000000;
    static int v,e,startPos;
    static List<Edge>[] list;
    static int[] dist;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        startPos = sc.nextInt();

        list = new ArrayList[v+1];
        dist = new int[v+1];

        Arrays.fill(dist,INF);
        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            list[x].add(new Edge(0,y,w));
        }

        dijkstra(startPos);

        for(int i = 1; i <= v; i++){
            System.out.println(dist[i]==INF?"INF":dist[i]);
        }

    }

    //다익스트라... 어렵당ㅋㅋ
    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[v+1];
        pq.add(new Edge(0,start,0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int cur = edge.end;
            if(checked[cur])continue;
            checked[cur] = true;

            //
            for(Edge next:list[cur]){
                if(dist[next.end] > dist[cur] + next.weight){
                    dist[next.end] = dist[cur] + next.weight;
                    pq.add(new Edge(0, next.end, dist[next.end]));
                }
            }
        }
    }
}
