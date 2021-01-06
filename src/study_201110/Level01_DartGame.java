package study_201110;

import java.util.Stack;

public class Level01_DartGame {

    public static void main(String[] args){

        String dartResult = "1S2D*3T";
        Stack<Integer> score = new Stack<>();
        String temp = "";
        int n = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c>='0'&&c<='9') {
                temp += c + "";
                n = Integer.parseInt(temp);
            }else if(c=='D'||c=='S'||c=='T'){
                if(c=='D') n *= n;
                if(c=='T') n *= n * n;
                score.push(n);
                temp="";
            }else if(c=='#'||c=='*'){
                if(c=='#'){
                    n = score.pop();
                    n *= -1;
                    score.push(n);
                }else{
                    n = score.pop();
                    if(score.isEmpty()){
                        n *= 2;
                        score.push(n);
                    }else{
                        n *= 2;
                        int m = score.pop();
                        m *=2;
                        score.push(m);
                        score.push(n);

                    }
                }
            }

        }
        int result = 0;
        int len = score.size();
        for(int i = 0; i < len; i++){
            int a = score.pop();
            System.out.println(a);
            result += a;
        }
        System.out.println(result);
    }

}
