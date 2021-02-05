package study_210205;

public class Programmers_60057 {
    public static void main(String[] args){
        String s = "aabbaccc";
        int len = s.length();
        int answer = s.length();

        for(int i = 1; i < len/2; i++){
            int length = compression(s,i).length();
            answer = Math.min(answer,length);
        }
//        System.out.println(answer);

    }

    public static String compression(String str, int i){
        int cnt =1;
        String comp = "";
        String pattern="";

        for(int j = 0; j <= str.length()+i; j+=i){
            String temp ="";

            if(j>=str.length()){
//                System.out.println("1 / "+j);
                temp = "";
            }else if(str.length() < j+ i){
//                System.out.println("2 / "+j);
                temp = str.substring(j);
            }else{
//                System.out.println("3 / "+j);
                temp = str.substring(j,j+i);
            }

            if(j != 0){
                if(temp.equals(pattern)){
                    cnt++;
                }else if(cnt >= 2){
                    comp += cnt+pattern;
                    cnt = 1;
                }else{
                    comp += pattern;
                }
            }
            pattern = temp;
        }
//        System.out.println("comp = "+comp);
        return comp;
    }

}
