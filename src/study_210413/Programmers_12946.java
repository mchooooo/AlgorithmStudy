package study_210413;

import java.util.ArrayList;
import java.util.List;

/*
* 하노이탑의 이동순서를 배열에 담아라!
*
* */
public class Programmers_12946 {
    public static void main(String[] args){
        int n = 2;
        int[][] answer = {};

        hanoi(2,1,2,3);
        answer = new int[list.size()/2][2];

        for(int i = 0; i < list.size(); i++){
            answer[i/2][i%2] = list.get(i);
        }

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
    static List<Integer> list = new ArrayList<>();
    public static void hanoi(int n, int start, int mid, int to){
        if(n == 1){
            System.out.println(start + " / " + to);
            list.add(start);
            list.add(to);
            return;
        }
        hanoi(n-1,start,to,mid);
        System.out.println(start + " / " + to);
        list.add(start);
        list.add(to);
        hanoi(n-1, mid, start, to);
    }

}
