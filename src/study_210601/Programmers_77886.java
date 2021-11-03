package study_210601;

import java.util.Stack;

public class Programmers_77886 {
    public static void main(String[] args) {
        String[] s = {"1110","100111100","0111111010"};
        String[] answer = new String[s.length];


        for(int i = 0; i < s.length; i++){
            String str = s[i];
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(st.size()>=2){
                    char x = st.pop();
                    char y = st.pop();
                    if(x =='1' && y == '1' && ch=='0'){
                        cnt++;
                        continue;
                    }else{
                        st.push(y);
                        st.push(x);
                    }
                }
                st.push(ch);
            }
            while(!st.isEmpty()){
                sb.insert(0,st.pop());
            }
            int idx = findZero(sb.toString());
            if(idx == -1){
                while(cnt-- > 0) {
                    sb.insert(0, "110");
                }
            }else {
                while (cnt-- > 0) {
                    sb.insert(idx+1, "110");
                }
            }
            answer[i] = sb.toString();
//            System.out.println(cnt);
//            System.out.println(st.toString());

        }

    }
    public static int findZero(String str){
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == '0') return i;
        }
        return -1;
    }
}
