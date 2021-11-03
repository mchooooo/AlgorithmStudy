package study_210522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11000 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            pq.add(new Class(Integer.parseInt(info[0]),Integer.parseInt(info[1])));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        while (!pq.isEmpty()){
            Class c = pq.poll();
            if (!room.isEmpty()) {
                if (c.start >= room.peek()) {
                    room.poll();
                }
            }
            room.add(c.end);
        }
        System.out.println(room.size());


    }
}

class Class implements Comparable<Class>{
    int start;
    int end;
    public Class(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o){
        if(this.start == o.start){
            return Integer.compare(this.end-this.start, o.end - o.start);
        }
        return Integer.compare(this.start, o.start);
    }
}
