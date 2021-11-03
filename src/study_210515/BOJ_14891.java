package study_210515;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
* 링크드리스트로 회전
* */
public class BOJ_14891 {
    static LinkedList<Integer>[] wheels = new LinkedList[4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            wheels[i] = new LinkedList<>();
            String info = br.readLine();
            for(int j = 0; j < 8; j++){
                char ch = info.charAt(j);
                wheels[i].add(Integer.parseInt(ch+""));
            }
        }

        int k = Integer.parseInt(br.readLine());

        while (k-->0){
            String[] sp = br.readLine().split(" ");
            int wheel = Integer.parseInt(sp[0]);
            int dir = Integer.parseInt(sp[1]);
            wheel -= 1;

            //왼쪽 확인
            checkLeft(wheel-1, -dir);
            //오른쪽 확인
            checkRight(wheel+1, -dir);
            //돌림
            rotate(wheel,dir);


        }
//        print();
        int answer = 0;
        for(int i = 0; i < 4; i++){
            if(wheels[i].get(0) == 1){
                answer += Math.pow(2,i);
//                System.out.println(answer);
            }
        }
        System.out.println(answer);


    }

    public static boolean check(int std, int comp){
        // 3 2
        if(std > comp){
            if(wheels[std].get(6) == wheels[comp].get(2)) return false;
            else return true;
        }else{//2 3
            if(wheels[std].get(2) == wheels[comp].get(6)) return false;
            else return true;
        }
    }

    public static void checkLeft(int wheel, int dir){
        if(wheel<0 || wheel>3) return;
        if(check(wheel, wheel+1)){
            checkLeft(wheel-1, -dir);
            rotate(wheel,dir);
        }
    }

    public static void checkRight(int wheel, int dir){
        if(wheel<0 || wheel>3) return;
        if(check(wheel,wheel-1)){
            checkRight(wheel+1, -dir);
            rotate(wheel,dir);
        }
    }

    public static void rotate(int wheel,int dir){
        if(dir == 1){
            wheels[wheel].addFirst(wheels[wheel].pollLast());
        }else{
            wheels[wheel].addLast(wheels[wheel].pollFirst());
        }

    }

    /*
    *
1 0 1 0 1 1 1 1
0 1 1 1 1 1 0 1
1 1 0 0 1 1 1 0
0 0 0 0 0 0 0 1

1 1 0 1 0 1 1 1
1 1 1 1 1 0 1 0
1 1 0 0 1 1 1 0
0 0 0 0 0 0 0 1
    * */
    public static void print(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(wheels[i].get(j)+" ");
            }
            System.out.println();
        }
    }

}
