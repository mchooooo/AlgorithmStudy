package study_210302;

import java.util.Scanner;

/*
* ㅋㅐ릭터 배열
* */
public class BOJ_9935_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String boom = sc.nextLine();

        String answer =  solution(str,boom);
        System.out.println(answer.length()==0?"FRULA":answer);
    }
    private static String solution(String s, String boom){
        char[] arr = new char[s.length()];
        int idx = 0;
        for(int i =0 ; i <s.length(); i++){
            arr[idx] = s.charAt(i);

            if(arr[idx] == boom.charAt(boom.length()-1)){
                if(idx - boom.length() + 1 < 0) {
                    idx++;
                    continue;
                }
                boolean isBoom = true;
                for(int j = 0; j < boom.length(); j++){
                    if(arr[idx - j] != boom.charAt(boom.length()-1-j)){
                        //b a 2                  b a 2
                        isBoom=false;
                        break;
                    }
                }
                if(isBoom){
                    idx -= boom.length();
                }

            }
            idx++;
        }

        return String.valueOf(arr,0,idx);
    }
}
