package study_210209;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197 {

    public static int[] parents;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++){
            Edge e = new Edge();
            e.start = sc.nextInt();
            e.end = sc.nextInt();
            e.weight = sc.nextInt();
            pq.add(e);
        }
        parents = new int[V+1];

        for(int i = 0; i <=V; i++){
            parents[i] = i;
        }

        int result = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            //사이클을 만들지 않으면 엣지를 추가하고 합침
            if(!isCycle(e.start,e.end)){
                result += e.weight;
                union(e.start,e.end);
            }
        }
        System.out.println(result);
    }
    //x,y의 루트를 찾아 같지 않으면 합침
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[y] = x;
        }
    }
    //x의 루트를 찾는 메소드 재귀 활용
    public static int find(int x){
        if(parents[x]==x) return x;
        return parents[x]=find(parents[x]);
    }

    //사이클 확인하는 메소드
    public static boolean isCycle(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y)return true;
        else return false;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
