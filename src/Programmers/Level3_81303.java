package Programmers;

import java.util.*;

public class Level3_81303 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        int size = n;
        Stack<Integer> delete = new Stack<>();
        for(int i = 0; i < cmd.length; i++){
            String s = cmd[i];
            if(s.charAt(0) == 'U'){
                int num = Integer.parseInt(s.substring(2));
                k -= num;
            }else if(s.charAt(0) == 'D'){
                int num = Integer.parseInt(s.substring(2));
                k += num;
            }else if(s.charAt(0) == 'C'){
                delete.push(k);
                size -= 1;
                if(k == size) k-=1;
            }else{
                int temp = delete.pop();
                if(temp <= k) k+=1;
                size += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append('O');
        }

        while(!delete.isEmpty()){
            sb.insert(delete.pop().intValue(),'X');
        }

        System.out.println(sb.toString());

    }

}
