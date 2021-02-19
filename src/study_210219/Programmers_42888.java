package study_210219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 유저 아이디와 이름을 맵에 저장 key 아이디, value 이름
* 반복문을 돌면서 맵에 저장
* 다시 반복을 통해 입장, 퇴장 메시지 저장
* */
public class Programmers_42888 {
    public static void main(String[] args){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp.length>2){
                if(!map.containsKey(temp[1])){
                    map.put(temp[1],temp[2]);
                }else{
                    map.replace(temp[1],map.get(temp[1]),temp[2]);
                }
            }
        }

        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            String str = "";
            if(temp[0].equals("Enter")){
                str = map.get(temp[1])+"님이 들어왔습니다.";
                list.add(str);
            }else if(temp[0].equals("Leave")) {
                str = map.get(temp[1]) + "님이 나갔습니다.";
                list.add(str);
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
//        for(String str : answer){
//            System.out.println(str);
//        }

    }
}
