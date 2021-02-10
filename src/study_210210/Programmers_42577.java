package study_210210;

import java.util.Arrays;

public class Programmers_42577 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        Arrays.sort(phone_book);
        String std = phone_book[0];
        boolean answer = true;

        for(int i = 1; i < phone_book.length;i++){
            if(phone_book[i].length() < std.length()) continue;
            if(std.equals(phone_book[i].substring(0,std.length()))){
                answer = false;
                break;
            }
        }

        System.out.println(answer);

    }
}
