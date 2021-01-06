package study_201103;

public class CodingChallenge_2_1 {

    public static void main(String[] args){
        int n = 4;
        int numOfBox = ((n+1)*n)/2;
        int[] answer = new int[numOfBox];
        int[][] temp = new int[n][n];

        temp[0][0] = 1;

        int dalpang = 1;
        int x=0;
        int y = 0;
        while(dalpang<numOfBox){

            while(x<n-1&&temp[x+1][y]==0){
                temp[++x][y]=++dalpang;
            }
            while(y<n-1&&temp[x][y+1]==0){
                temp[x][++y]=++dalpang;
            }
            while(x>=0&&y>=0&&temp[x-1][y-1]==0){
                temp[--x][--y]=++dalpang;
            }

        }
        dalpang = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[dalpang++] = temp[i][j];
            }
        }

    }
}
