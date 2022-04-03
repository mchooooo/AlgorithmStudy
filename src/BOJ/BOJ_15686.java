package BOJ;

import java.util.*;

public class BOJ_15686 {
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int _x, int _y){
            x = _x;
            y = _y;
        }
        public Node(int _x, int _y, int _cnt){
            x = _x;
            y = _y;
            cnt = _cnt;
        }
    }
    static int n;
    static int m;
    static int[][] arr;
    static List<Node> list;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        //치킨집 리스트에 넣고 m개 뽑아서 bfs 최솟값 확인
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        answer = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2) {
                    arr[i][j] = 0;
                    list.add(new Node(i,j));
                }
            }
        }
        //치킨집 선택
        select(0,0);
        System.out.println(answer);
    }

    public static void bfs(){
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] chk = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 2) {
                    q.add(new Node(i,j,0));
                    chk[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                //범위 밖이면 ㅠㅐ쓰
                if(!isValid(nx,ny)) continue;
                //이미 방문한 곳 패스
                if(chk[nx][ny]) continue;
                if(arr[nx][ny] == 0){
                    chk[nx][ny] = true;
                    q.add(new Node(nx,ny,node.cnt+1));
                }else if(arr[nx][ny] == 1){
                    //가정집이면 거리+
                    chk[nx][ny] = true;
                    q.add(new Node(nx,ny,node.cnt+1));
                    sum += node.cnt+1;
                }
            }
        }
        answer = Math.min(answer, sum);
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x>= n || y >= n) return false;
        return true;
    }

    public static void select(int cnt, int idx){
        if(cnt == m){
            //bfs시작하겠죠?
            bfs();
//            print();
//            System.out.println("-------------------");
            return;
        }
        for(int i = idx; i < list.size(); i++){
            Node node = list.get(i);
            arr[node.x][node.y] = 2;
            select(cnt+1, i+1);
            arr[node.x][node.y] = 0;
        }
    }
    public static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }
}
