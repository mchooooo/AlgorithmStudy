package study_210130;

import java.util.*;

public class Programmers_72411 {
    public static Map<String,Integer> map = new HashMap<String,Integer>();
    public static char[] temp;
    public static void main(String[] args){
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};

        //문자열 사전순 정렬
        for(int i = 0; i < orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = new String(temp);
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < orders.length; i++){
            temp = orders[i].toCharArray();
            for(int j = 1; j <= temp.length; j++){
                comb(temp.length,st,j);
            }
        }

        List<String> list = new ArrayList<String>();
        List<Integer> maxList = new ArrayList<Integer>();
        for(int i = 0; i < course.length; i++){
            int max = Integer.MIN_VALUE;
            for(String str : map.keySet()){
                if(course[i] == str.length()){
                    if(map.get(str) > max){
                        max = map.get(str);
                    }
                }
            }
            maxList.add(max);
        }

        for(int i = 0; i < course.length; i++){
            for(String str : map.keySet()){
                if(course[i]==str.length() && maxList.get(i)==map.get(str) && map.get(str) > 1){

                    list.add(str);
                }
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        for(String str : answer){
            System.out.println(str);
        }
    }

    public static void comb(int n, Stack<Integer> st, int r){
        if(r == 0){
            String str = "";
            for(int i : st){
                str += temp[i]+"";
            }
            if(!map.containsKey(str)){
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }
        }

        int small = st.isEmpty()?0:st.lastElement()+1;

        for(int next = small; next < n; next++){
            st.push(next);
            comb(n,st,r-1);
            st.pop();
        }
    }
}
