package study_210217;

/*
* 보행자 천국
* DP 활용
* H[i][j] = i행 j열에서 오른쪽으로 갈 수 있는 경우의 수
* V[i][j] = i행 j열에서 아래로 갈 수 있는 경우의 수
*
* */
public class Programmers_1832 {
    static int MOD = 20170805;
    public static void main(String[] args){

        int m = 3;
        int n = 6;
        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        int answer = 0;
        int[][] V = new int[m+1][n+1];
        int[][] H = new int[m+1][n+1];
        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){
                if(i==0 && j== 0) {
                    H[i+1][j+1] = 1;
                    V[i+1][j+1] = 1;
                    continue;
                }
                if(cityMap[i][j] == 0){
                    //현재자리 = 오른쪽에서 온 경우 + 위에서 온 경우
                    H[i+1][j+1] = (H[i+1][j] + V[i][j+1]) % MOD;
                    V[i+1][j+1] = (H[i+1][j] + V[i][j+1]) % MOD;
                }else if(cityMap[i][j]==1){
                    //통행 금지 구역은 경우의 수 0
                    H[i+1][j+1] = 0;
                    V[i+1][j+1] = 0;
                }else if(cityMap[i][j]==2){
                    //진행 방향 그대로만 올 수 있는 자리
                    H[i+1][j+1] = H[i+1][j];
                    V[i+1][j+1] = V[i][j+1];
                }
            }
        }
        System.out.println(V[m][n]);
        for(int i = 0; i <=m; i++){
            for(int j = 0; j <= n; j++){
                System.out.print(V[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i = 0; i <=m; i++){
            for(int j = 0; j <= n; j++){
                System.out.print(H[i][j]+" ");
            }
            System.out.println();
        }
    }
}
