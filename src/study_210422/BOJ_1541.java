package study_210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
* 덧셈부터 계산하고 빼면 최소값
* split에서 "+"는 적용안됨 --> 메타케릭터? "\\+"사용
* */
public class BOJ_1541 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        String[] sp = str.split("-");
        for(int i = 0; i < sp.length; i++){
            int sum = 0;
            String[] plus = sp[i].split("\\+");

            for(int j = 0; j < plus.length; j++){

                sum += Integer.parseInt(plus[j]);
            }

            if(answer == Integer.MAX_VALUE){
                answer = sum;
            }else{
                answer -= sum;
            }
        }


        System.out.println(answer);
    }


    public static int cal(char ch, int x, int y){
        return ch =='+' ? x+y : x-y;
    }
}
