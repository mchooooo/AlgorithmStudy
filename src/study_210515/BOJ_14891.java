package study_210515;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheels = new int[4][8];
        for(int i = 0; i < 4; i++){
            String info = br.readLine();
            for(int j = 0; j < info.length(); j++){
                int num = Integer.parseInt(info.charAt(j)+"");
                wheels[i][j] = num;
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            boolean[] check = new boolean[4];
            String[] info = br.readLine().split(" ");
            int wheel = Integer.parseInt(info[0]);
            int dir = Integer.parseInt(info[1]);

            rotate(wheels, wheel, dir);
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(wheels[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void rotate(int[][] wheels, int wheel, int dir){
        wheel -= 1;

        if(dir == 1){
            int temp = wheels[wheel][0];
            for(int i = 1; i < 8; i++){
                int save = wheels[wheel][i];
                wheels[wheel][i] = temp;
                temp = save;
            }
            wheels[wheel][0] = temp;
        }else{
            int temp = wheels[wheel][7];
            for(int i = 6; i >=0; i--){
                int save = wheels[wheel][i];
                wheels[wheel][i] = temp;
                temp = save;
            }
            wheels[wheel][7] = temp;
        }
    }
}
