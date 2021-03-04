package study_210301;

public class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;
    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.weight, o.weight);
    }
}
