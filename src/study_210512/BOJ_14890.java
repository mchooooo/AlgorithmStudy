package study_210512;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14890 {
    static int N;
    static int L;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            s = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(check(i,0,0)) cnt++;
            if(check(0,i,1)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean check(int x, int y, int dir){
        //dir == 0, 가로방향 확인
        //dir == 1, 세로방향 확인
        int[] height = new int[N];
        boolean[] visited = new boolean[N];
        //height 초기화
        for(int i = 0; i < N; i++){
            height[i] = (dir==0) ? arr[x][y+i] : arr[x+i][y];
        }

        //확인 시작

        for(int i = 0; i < N-1; i++){
            //현재 높이와 이전 높이가 같다면 패쓰
            if(height[i] == height[i+1]) {
                continue;
            }
            //높이가 2이상이면 무적권 못 지나감
            if (Math.abs(height[i] - height[i+1]) > 1) {
                return false;
            }

            //현재 높이와 이전 높이가 다르고 오르막인 경우
            if(height[i] + 1 == height[i + 1]){
                //발판을 놓을 수 있는지 확인해야함
                for(int j = i; j > i-L; j--){
                    if( j < 0) return false;
                    if( visited[j] ) return false;
                    if(height[j] != height[i]) return false;
                    visited[j] = true;
                }
            }else if(height[i] - 1 == height[i + 1]){//내리막인 경우
                //발판을 놓을 수 있는지 확인
                for(int j = i+1; j <= i+L; j++){

                    if(j>=N) return false;
                    if(visited[j]) return false;
                    if(height[j]!=height[i+1]) return false;
                    visited[j] = true;
                }

            }

        }

        return true;

    }
}
