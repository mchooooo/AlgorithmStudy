package study_210430;

import java.util.Arrays;

public class Programmers_77484 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer = new int[2];
        int zeroCnt = 0;
        int winCnt = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                lottos[i] = 46;
                zeroCnt++;
            }
        }

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int i = 0; i < lottos.length; i++){
            int lo = lottos[i];
            for(int j = 0; j < lottos.length; j++){
                if(lo == win_nums[j]){
                    winCnt++;
                }
            }
        }
        answer[0] = calRate(winCnt+zeroCnt);
        answer[1] = calRate(winCnt);

        System.out.println(answer[0] + " / " + answer[1]);
    }
    public static int calRate(int num){
        switch (num){
            case 6 :{
                return 1;
            }
            case 5 :{
                return 2;
            }
            case 4 : {
                return 3;
            }
            case 3 : {
                return 4;
            }
            case 2 : {
                return 5;
            }
            default: return 6;
        }
    }
}
