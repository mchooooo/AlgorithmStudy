package study_210211;

import java.util.PriorityQueue;

public class Programmers_42861 {
    static int[] parents;
    public static void main(String[] args){
        int n = 4;
        int[][] cost = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parents = new int[n];
        //부모 노드를 찾기 위해 초기화
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }

        //우선순위 큐 생성
        for(int i = 0;i < cost.length; i++){
            Edge e = new Edge(cost[i][0],cost[i][1],cost[i][2]);
            pq.add(e);
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(!isCycle(e.start,e.end)){
                answer+=e.cost;
                union(e.start,e.end);
            }
        }
        System.out.println(answer);

    }
    public static int find(int x){
        if(parents[x]==x)return x;
        else return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[x] = y;
        }
    }

    public static boolean isCycle(int x, int y){
        x=find(x);
        y=find(y);
        if(x==y) return true;
        else return false;
    }

}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.cost,o.cost);
    }
}