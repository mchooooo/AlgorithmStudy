package study_201103;

public class CodingChallenge_2_2 {
    static int zero = 0;
    static int one = 0;
    static int[][] inp;
    public static void main(String[] args){

        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        inp = arr;
        divide(arr.length,0,0);
        System.out.println(zero);
        System.out.println(one);


    }

    public static void divide(int len, int x, int y){
        if(len == 1){
            if(inp[x][y]==0) zero++;
            else one++;
            return;
        }
        int mid = len/2;

        if(check(len,x,y)) return;

        divide(mid,x,y);
        divide(mid,x+mid,y);
        divide(mid,x,y+mid);
        divide(mid,mid+x,mid+y);

    }

    public static boolean check(int len, int x, int y){

        int n = inp[x][y];
        for(int i =x; i <len+x; i++){
            for(int j=y; j < len+y; j++){
                if(inp[i][j] != n) return false;
            }
        }

        if(n==0) zero++;
        else one++;
        return true;

    }

}
