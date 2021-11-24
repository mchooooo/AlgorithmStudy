package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* 친구 네트워크
* 유니온-파인드
* */
public class BOJ_4195 {
    static int[] parent;
    static int[] level;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            parent = new int[n*2]; //최대 친구 수 모두 다른 친구면 n*2
            level = new int[n*2]; // 마찬가지 ㅋㅋ

            for(int i = 0; i < n*2; i++){//parent, level 초기화
                parent[i] = i;
                level[i] = 1;
            }

            //key = name, value = idx !
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;
            int max = 0;
            for(int i = 0; i < n; i++){
                String[] friends = br.readLine().split(" ");
                //map에 없다면 추가, idx로 parent 배열에서 찾을 수 있다.
                if(!map.containsKey(friends[0])){
                    map.put(friends[0],idx++);
                }
                if(!map.containsKey(friends[1])){
                    map.put(friends[1],idx++);
                }
//                System.out.println(friends[0] + " / " + friends[1]);
                int result = union(map.get(friends[0]),map.get(friends[1]));
//                System.out.println(result);
            }
//            System.out.println("parent");
//            for(int i = 0; i < parent.length; i++){
//
//                System.out.print(i+" / " + parent[i]+" / ");
//            }
//            System.out.println();
//            System.out.println("level");
//            for(int i = 0; i < parent.length; i++){
//
//                System.out.print(i+ " / " + level[i]+" / ");
//            }
            int a = 0;
            for(int i = 0; i < level.length; i++){
                if(max < level[i]){
                    max = level[i];
                    a = i;
                }
            }
            System.out.println(parent[a]);
            for(String name : map.keySet()){
                if(map.get(name) == a){
                    System.out.println(name);
                }
            }


        }
    }
    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static int union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }
        return level[x];
    }
}
