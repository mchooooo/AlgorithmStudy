package study_210423;

import java.util.ArrayList;
import java.util.List;

public class Programmers_67257 {
    static char[] prior = {'+', '-', '*'};
    static List<Long> numList = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();
    static boolean[] check = new boolean[3];
    static long answer;
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";


        answer= 0;
        String temp = "";
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch=='*'){
                numList.add(Long.parseLong(temp));
                opList.add(ch);
                temp = "";
            }else{
                temp += ch+"";
            }
        }
        numList.add(Long.parseLong(temp));


        dfs(0, new char[3]);
        System.out.println(answer);


    }

    public static long cal(long a, long b, char op){
        long num = 0;
        switch (op){
            case '+': {
                return a + b;
            }
            case '-':{
                return a-b;
            }
            case '*':{
                return a*b;
            }
        }
        return num;
    }

    public static void dfs(int cnt, char[] p){

        if(cnt == 3){
            System.out.println(p[0] +" / " + p[1] + " / " + p[2]);
            ArrayList<Long> cNums = new ArrayList<>(numList);
            ArrayList<Character> cOps = new ArrayList<Character>(opList);


            //계산
            for(int i = 0; i < p.length; i++) { // 0-2
                for(int j = 0; j < cOps.size(); j++) { // 0-3
                    if(p[i] == cOps.get(j)) {
                        // 리스트는 지울때 한칸씩밀리고 배열의 사이즈가 동적으로 변하므로
                        // (j 를 두번 remove 하고 j-- 처리를 해준것이다.)
                        Long res = cal(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;

        }
        //조합구하기
        for(int i = 0; i < 3; i++){
            if(!check[i]){
                check[i] = true;
                p[cnt] = prior[i];
                dfs(cnt+1, p);
                check[i] = false;
            }
        }
    }
}
