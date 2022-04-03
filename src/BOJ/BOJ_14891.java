package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14891 {

    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];
        for(int i = 0; i < 4; i++){
            String inp = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = inp.charAt(j) -'0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            String[] sp = br.readLine().split(" ");
            int num = Integer.parseInt(sp[0])-1;
            int dir = Integer.parseInt(sp[1]);

            checkLeft(num-1, -dir);
            checkRight(num+1, -dir);

            rotate(num, dir);

        }

//        for(int i = 0; i < 4; i++){
//            for(int j = 0; j < 8; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        int answer = 0;

        for(int i = 0; i < 4; i++){
            if(arr[i][0] == 1){
                answer += Math.pow(2,i);
            }
        }
        System.out.println(answer);

    }

    static boolean chk(int num, int cmp){
        if(num < cmp){
            //2 3
            return arr[num][2] != arr[cmp][6];
        }else{
            //3 2
            return arr[num][6] != arr[cmp][2];
        }
    }

    static void checkLeft(int num, int dir){
        if(num < 0 || num > 3) return;
        if(chk(num, num+1)){
            checkLeft(num-1, -dir);
            rotate(num, dir);
        }
    }
    static void checkRight(int num, int dir){
        if(num < 0 || num > 3) return;
        if(chk(num, num-1)){
            checkRight(num+1, -dir);
            rotate(num, dir);
        }
    }

    static void rotate(int num, int dir){
        int[] temp = new int[8];

        for(int i = 0; i < 8; i++){
            temp[i] = arr[num][i];
        }

        if(dir == 1){
            for(int i = 0; i < 8; i++){
                arr[num][(i+1)%8] = temp[i];
            }
        }else{
            for(int i = 7; i >= 0; i--){
                arr[num][i] = temp[(i+1)%8];
            }
        }
    }
}
