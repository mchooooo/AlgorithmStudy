package study_210522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            pq.add(new Room(Integer.parseInt(info[0]),Integer.parseInt(info[1])));
        }

        int cnt = 0;
        int end = 0;

        while(!pq.isEmpty()){
            Room r = pq.poll();
            if(r.start>=end){
                cnt++;
                end = r.end;
            }
        }
        System.out.println(cnt);

    }
}
class Room implements Comparable<Room>{
    int start;
    int end;
    public Room(int start, int end){
        this.start = start;
        this.end=end;
    }

    @Override
    public int compareTo(Room o){
        if(this.end == o.end){
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.end, o.end);
    }
}
