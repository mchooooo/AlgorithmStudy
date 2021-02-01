package study_210201;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//다익스트라 알고리즘 합승을 통한 비용 계산이 안됨.. 플로이드-워샬 사용해볼예정..
public class Programmers_72413 {

    public static void main(String[] args){
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        List<Edge>[] list = new ArrayList[n+1];

        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < fares.length; i++ ){
            int x = fares[i][0];
            int y = fares[i][1];
            int z = fares[i][2];
            list[x].add(new Edge(y,z));
            list[y].add(new Edge(x,z));
        }

        //다익스트라 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[n+1];
        Edge[] dist = new Edge[n+1];
        for(int i = 0; i < dist.length; i++){
            if(i==s){
                dist[i] = new Edge(i,0);
            }else{
                dist[i] = new Edge(i,Integer.MAX_VALUE);
            }
            pq.add(dist[i]);
        }


        while (!pq.isEmpty()){
            Edge edge = pq.poll();
//            System.out.println(" @ "+list[edge.v].get(0).v+" / "+ list[edge.v].get(0).weight);
            for(Edge next : list[edge.v]){
                if(!checked[next.v] && dist[next.v].weight > dist[edge.v].weight + next.weight){
                    dist[next.v].weight = dist[edge.v].weight + next.weight;
                    pq.remove(dist[next.v]);
                    pq.add(dist[next.v]);
                }
            }
            checked[edge.v] = true;
        }

        for(Edge e : dist){
            System.out.println(" 4 -> "+e.v+" / "+e.weight);
        }

    }

}

class Edge implements Comparable<Edge>{
    int v, weight;

    public Edge(int v, int weight){
        this.v = v;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight,o.weight);
    }
}
