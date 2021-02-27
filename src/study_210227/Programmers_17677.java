package study_210227;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 뉴스 클러스터링
* 1. 문자열 처리 특수문자,숫자공백제거
* 2. 교집합은 set으로, 합집합은 list에 몰아넣기 ㅋㅋ
* */
public class Programmers_17677 {
    public static void main(String[] args){

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        int cons = 65536;
        int answer = 0;
        //소문자로 바꿈
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println(str1 +" / "+ str2);


        //리스트 뽑기, 자카드 유사도
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        boolean flag = false;
        for(int i = 0; i < str1.length()-1; i++){
            String temp = "";
            char ch = str1.charAt(i);
            if(ch >='a' && ch <='z'){
                char ch2 = str1.charAt(i+1);
                if(ch2 >= 'a' && ch2 <='z'){
                    temp = ch+""+ch2;
                    if(str1List.contains(temp)){
                        flag=true;
                    }

                    str1List.add(temp);
                }
            }
            temp = "";
        }
        for(int i = 0; i < str2.length()-1; i++){
            String temp = "";
            char ch = str2.charAt(i);
            if(ch >='a' && ch <='z'){
                char ch2 = str2.charAt(i+1);
                if(ch2 >= 'a' && ch2 <='z'){
                    temp = ch+""+ch2;
                    str2List.add(temp);
                }
            }
            temp = "";
        }
        System.out.println(str1List.size() +" / "+str2List.size());

        if(str1List.size()==0 && str2List.size()==0){
            System.out.println("return "+cons);
        }

        //합집합, 교집합 만들기
        Set<String> set = new HashSet<>();
        List<String> hap = new ArrayList<>();
        List<String> gyo = new ArrayList<>();
        for(int i = 0; i < str1List.size(); i++){
            System.out.println(str1List.get(i));
        }
        if(!flag) {
            System.out.println("멀티집합아님");
            for (int i = 0; i < str1List.size(); i++) {
                str2List.add(str1List.get(i));
            }
            str1List.clear();
            for (int i = 0; i < str2List.size(); i++) {
                if (set.contains(str2List.get(i))) {
                    str1List.add(str2List.get(i));
                }
                set.add(str2List.get(i));
            }

            System.out.println(str1List.size() + " / " + set.size());
            //유사도 계산
            double d = (double) str1List.size() / set.size();
            System.out.println(d);
            d = Math.floor(d * cons);
            System.out.println(d);
            answer = (int)d;
        }else{
            System.out.println("멀티집합");
            for(int i = 0; i < str1List.size(); i++){
                String temp = str1List.get(i);
                int str1Cnt = 0;
                int str2Cnt = 0;
                if(hap.contains(temp)){
                    continue;
                }
                for(int j = 0; j < str1List.size(); j++){
                    if(temp.equals(str1List.get(j))){
                        str1Cnt++;
                    }
                }
                for(int j = 0; j < str2List.size(); j++){
                    if(temp.equals(str2List.get(j))){
                        str2Cnt++;
                    }
                }

                int hapCnt = Math.max(str1Cnt,str2Cnt);
                int gyoCnt = Math.min(str1Cnt,str2Cnt);

                for(int j = 0; j <gyoCnt; j++){
                    gyo.add(temp);
                }
                for(int j = 0; j <hapCnt; j++){
                    hap.add(temp);
                }

            }
            for(int i = 0; i < str2List.size(); i++){
                String temp = str2List.get(i);
                int str1Cnt = 0;
                int str2Cnt = 0;
                if(hap.contains(temp)){
                    continue;
                }
                for(int j = 0; j < str1List.size(); j++){
                    if(temp.equals(str1List.get(j))){
                        str1Cnt++;
                    }
                }
                for(int j = 0; j < str2List.size(); j++){
                    if(temp.equals(str2List.get(j))){
                        str2Cnt++;
                    }
                }

                int hapCnt = Math.max(str1Cnt,str2Cnt);
                int gyoCnt = Math.min(str1Cnt,str2Cnt);

                for(int j = 0; j <gyoCnt; j++){
                    gyo.add(temp);
                }
                for(int j = 0; j <hapCnt; j++){
                    hap.add(temp);
                }

            }
            //유사도 계산
            double d = (double) gyo.size() / hap.size();
            System.out.println(d);
            d = Math.floor(d * cons);
            System.out.println(d);
            answer = (int)d;
        }

        System.out.println(answer);
    }
}
