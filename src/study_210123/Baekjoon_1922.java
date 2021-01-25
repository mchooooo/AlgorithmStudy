package study_210123;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//네트워크 연결

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;


    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Baekjoon_1922 {

    static int N;
    static int M;
    static PriorityQueue<Edge> pq;
    static int[] parents;
    static boolean[] visited;
    static int result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        parents = new int[N+1];
        visited = new boolean[N+1];
        result =0;

        pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Edge edge = new Edge();
            edge.start=a;
            edge.end=b;
            edge.cost=c;
            pq.add(edge);
        }

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
        for(int i = 0; i < M; i++){
            Edge e = pq.poll();
            int start = e.start;
            int end = e.end;

            int a = find(start);
            int b = find(end);

            if(a==b) continue;

            union(a,b);

            result += e.cost;
        }

        System.out.println(result);
    }

    public static int find(int a){
        if(a==parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parents[aRoot] = b;
        }else{
            return;
        }
    }


}
