package study_210420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 치킨 배달???
* */
public class BOJ_15686 {

    static List<Node> chicken;
    static List<Node> house;
    static boolean[] visit;
    static int N;
    static int M;
    static int answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                if(sp[j].equals("2")) chicken.add(new Node(i,j));
                if(sp[j].equals("1")) house.add(new Node(i,j));
            }
        }

        visit = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(answer);



    }
    public static void dfs(int start, int cnt){
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;


                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            answer = Math.min(answer, res);
            return;
        }

        for(int i = start; i < chicken.size() ; i++){
            visit[i] = true;
            dfs(i+1, cnt+1);
            visit[i] = false;
        }

    }

}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
