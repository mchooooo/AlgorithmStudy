package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t>0){
            Deque<Integer> dq = new LinkedList<>();
            String method = br.readLine();
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                br.readLine();
                solZero(method);
                t--;
                continue;
            }

            String str = br.readLine();

            String temp = "";

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch >= '0' && ch <= '9'){
                    temp += ch;
                }else if(ch == ','){
                    dq.add(Integer.parseInt(temp));
                    temp = "";
                }else{
                    continue;
                }
            }
            dq.add(Integer.parseInt(temp));
            int pos = 0;
            boolean flag = true;
            for(int i = 0; i < method.length(); i++){
                char ch = method.charAt(i);
                if(ch == 'D'){

                    if(pos == 0){
                        if(dq.pollFirst()==null){
                            System.out.println("error");
                            flag = false;
                            break;
                        }
                    }else{
                        if(dq.pollLast()==null){
                            System.out.println("error");
                            flag = false;
                            break;
                        }
                    }
                }else{
                    if(pos == 0) pos = 1;
                    else pos = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            if(!flag){
                t--;
                continue;
            }
            sb.append("[");
            if(pos == 0){
                while (!dq.isEmpty()){
                    sb.append(dq.pollFirst());
                    sb.append(",");
                }
            }else{
                while (!dq.isEmpty()){
                    sb.append(dq.pollLast());
                    sb.append(",");
                }
            }
            if(sb.length()>1) {
                sb.delete(sb.length() - 1, sb.length());
            }

            sb.append("]");
            System.out.println(sb);


            t--;
        }
    }

    public static void solZero(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'D'){
                System.out.println("error");
                return;
            }
        }
        System.out.println("[]");
    }
}
