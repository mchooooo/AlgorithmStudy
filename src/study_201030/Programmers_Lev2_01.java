package study_201030;

public class Programmers_Lev2_01 {

    public static void main(String[] args){
        String s = "baabaa";
        String str ="";
        int cnt = 0;
        for(int i = 0; i < s.length()-1; i++){
            char temp = s.charAt(i);
            if(temp==s.charAt(i+1)){
                str += temp+s.charAt(i+1)+"";
                System.out.print(str);
                s=s.replace(str,"");
            }
            str="";
        }
        System.out.print(s);

    }

}
