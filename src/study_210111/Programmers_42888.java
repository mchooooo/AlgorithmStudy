package study_210111;

import java.util.ArrayList;
import java.util.List;

public class Programmers_42888 {

    public static void main(String[] args){

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = {};

        List<User> userList = new ArrayList<User>();
        List<String> answerList = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp.length==2){
                userList.add(new User(temp[0],temp[1]));
            }else{
                userList.add(new User(temp[0],temp[1],temp[2]));
            }
        }

        for(int i = 0; i < userList.size(); i++){
            User user = userList.get(i);
            if(user.state.equals("Change")){
                for(int j=0;j<userList.size();j++){
                    if(user.id.equals(userList.get(j).id)){
                        userList.get(j).name = user.name;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < userList.size(); i++){
            User user = userList.get(i);

            if(user.state.equals("Enter")){
                for(int j = 0; j < i; j++){
                    if(user.id.equals(userList.get(j).id)){
                        userList.get(j).name=user.name;
                    }
                }
//                user.answer=user.name+"님이 들어왔습니다.";
            }
            if(user.state.equals("Leave")){
                for(int j = 0; j < userList.size(); j++){
                    if(user.id.equals(userList.get(j).id)){
                        user = userList.get(j);
                        break;
                    }
                }
//                user.answer=user.name+"님이 나갔습니다.";
            }
        }

        for(int i = 0; i < userList.size(); i++){
            User user = userList.get(i);

            if(user.state.equals("Enter")){
                answerList.add(user.name+"님이 들어왔습니다.");
            }
            if(user.state.equals("Leave")){
                answerList.add(user.name+"님이 나갔습니다.");
            }
        }

        answer = new String[answerList.size()];

        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }



    }
}

class User{
    public String state;
    public String id;
    public String name;
    public String answer;
    public User(String state, String id, String name){
        this(state,id);
        this.name=name;
    }
    public User(String state, String id){
        this.id = id;
        this.state=state;
    }
}
