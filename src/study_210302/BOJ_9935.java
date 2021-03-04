package study_210302;

import java.util.Scanner;
import java.util.Stack;

/*
* 문자열 폭발
* 1. 문자열을 스택<char>에 추가
* 2. 스택에 추가하면서 폭발 문자열의 마지막 글자가 나온다면 이전에 넣은 문자열을 꺼내 폭탄인지 확인
* 3. 스택이 비었다면 FRULA
* 메모리 초과
* 캐릭터 배열로 ㄱㄱ
* */
public class BOJ_9935 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String boom = sc.nextLine();

        Stack<Character> st = new Stack<>();
        Stack<Character> tempSt = new Stack<>();



        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            //현재 char가 폭발 문자열의 마지막과 같지 않다면 추가
            if(i<boom.length()||ch != boom.charAt(boom.length()-1)){
                st.push(ch);
            }else{//같다면  ch = 4
                tempSt.push(ch);
                for(int j = 0; j < boom.length()-1; j++){
                    char c = st.pop();
                    tempSt.push(c);
                }
                String temp = "";
                while(!tempSt.isEmpty()){
                    temp += tempSt.pop()+"";
                }
                if(!temp.equals(boom)){
                    for(int j = 0; j < temp.length(); j++){
                        char c = temp.charAt(j);
                        st.push(c);
                    }
                }

            }
        }

        if(st.isEmpty()){
            System.out.println("FRULA");
        }else {
            String t = "";
            for (int i = 0; i < st.size(); i++) {
                t += st.get(i);
            }
            System.out.println(t);
        }
    }
}
