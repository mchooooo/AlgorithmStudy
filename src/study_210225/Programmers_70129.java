package study_210225;

import java.util.Stack;

/*
* 이진변환반복하기
* 1이 될 때까지 이진 변환
* 사라진 0의 개수, 변환 수
* 조건대로 구현하면 될 듯
* 1. 0제거
* 2. 길이를 이진수로 변환
* */
public class Programmers_70129 {
    public static void main(String[] args){
        int[] answer = new int[2];
        String s = "1111111";
        int changeCnt = 0;
        int deleteZero = 0;
        //변환 하면서 s가 "1"이면 반복 종료
        while(!s.equals("1")){
            changeCnt++;
            int prevLen = s.length();
            s = s.replace("0","");
            int sLen = s.length();
            deleteZero += prevLen - sLen;
            s = binaryChange(sLen);
        }
        answer[0] = changeCnt;
        answer[1] = deleteZero;
    }

    //길이를 이진수로 변환
    private static String binaryChange(int n){
        String s = "";
        Stack<String> st = new Stack<>();
        while(n >= 1){
            int remain = n%2;
            st.push(remain+"");
            n /= 2;
        }

        while(!st.isEmpty()){
            s+=st.pop();
        }
        return s;
    }
}
