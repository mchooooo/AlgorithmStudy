package study_200212_2789;

import java.util.Scanner;

public class main {

    public static void main(String[] args){
        int row; //줄의 개수
        int[] curTab = new int[1000]; //현재 탭의 개수
        int[] tab = new int[1000]; // 각 줄의 올바른 탭의 개수
        int[] diff = new int[1000]; // 현재 탭의 개수와 올바른 탭의 개수의 차이
        int update = 0; //편집 수
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt(); //입력: 줄 4

        for(int i = 0; i < row; i++){
            curTab[i] = sc.nextInt(); //입력: 현재 탭의 개수 입력
            //1 2 3 4
        }

        for(int i = 0; i < row; i++){
            tab[i] = sc.nextInt(); // 입력: 올바른 탭의 개수
            //3 1 1 0
            diff[i] = tab[i] - curTab[i]; // 올바른 탭의 개수 - 현재 탭의 개수 저장
            //2 -1 -2 -4

        }


        if(row == 1) { // 줄이 1이라면
            System.out.println(diff[0]); // 한 줄이니까 걍 차이를 출력 ㅋㅋ

        }else{

            //기준 값을 정함
            int prev = diff[0]; //2
            int cur = diff[0];  //2

            for(int i = 1; i < row; i++){

                if(diff[i] >= 0){

                    if(prev < 0){ //부호가 다를 경우
                        update += Math.abs(prev);
                        prev = diff[i];
                    }else if(prev < diff[i])
                        prev = diff[i];
                    else{
                        update += Math.abs(prev) - Math.abs(diff[i]);
                        prev = cur = diff[i];
                    }

                }else{
                    if(prev > 0){
                        update += prev;
                        prev = diff[i];
                    }else if(prev > diff[i])
                        prev = diff[i];
                    else{
                        update += Math.abs(prev) - Math.abs(diff[i]);
                        prev = cur = diff[i];
                    }
                }

            }

            update += Math.abs(prev);

        }
        System.out.println(update);
    }
}
