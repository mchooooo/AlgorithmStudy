package study_201118;

public class Level01_12903 {
    //프로그래머스 레벨1 가운데 글자 가져오기
    public static void main(String[] args){
        String s = "qwer";

        String answer = "";

        if(s.length()%2==1){
            answer = s.charAt(s.length()/2)+"";
        }else{
            answer = s.substring(s.length()/2-1,s.length()/2+1);
        }

        System.out.println(answer);

    }
}
