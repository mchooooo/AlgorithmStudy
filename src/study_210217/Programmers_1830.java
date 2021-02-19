package study_210217;

/*
* 브라이언의 고민
* 규칙 1. 특정 단어 글자 사이마다 같은 기호
* 규칙 2. 특정 단어 앞뒤에 같은 기호
* 해설 참고 : https://tech.kakao.com/2017/08/11/code-festival-round-1/
* 1. 기호의 개수가 1개 || 3개 이상 --> 규칙 1
* 2. 기호의 개수 2개 && 기호 사이에 들어간 대문자의 개수가 2개 이상 --> 규칙 2
* 3. 기호의 개수 2개 && 사이에 들어간 글자의 수가 1 --> 규칙 1,2 모두 적용 가능하나 규칙 1,2가 모두 적용된 경우가 아니면 규칙 2
**/
//완성 필요..
public class Programmers_1830 {

    public static void main(String[] args){
        String sentense = "aGbWbFbDakGnWnLk"; //GWFD GWL
        System.out.println(sentense);
        findRule(sentense);



    }

    //대문자 확인
    public static boolean isCapital(char c){
        if(c>='A' && c <= 'Z') return true;
        return false;
    }

    //소문자 확인
    public static boolean isSmall(char c){
        if(c>='a' && c<='z') return true;
        return false;
    }

    //어떤 규칙이 적용되었는지 찾기
    public static void findRule(String s){
        int numUpper = 0;
        int numSmall = 0;
        char ruleWord = findSign(s);
        if(isSmall(s.charAt(0))){
            s = ruleTwo(s);
        }
        System.out.println(s);


    }

    //기호 찾는 함수
    public static char findSign(String s){
        //규칙 2의 경우 기호찾기 가장 앞이 소문자면 기호
        if(isSmall(s.charAt(0))) return s.charAt(0);
        char ch = '\0';
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(isSmall(temp)){
                ch = temp;
                break;
            }
        }
        return ch;
    }

    public static String ruleOne(String s){
        //규칙 1 검사

        char c = '\0';
        int cnt = 0;
        int len = s.length();
        //기호 글자 찾기


        return s;
    }
    public static String ruleTwo(String s){
        char sign = findSign(s);
        String temp = "";
        int cnt = 0;
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(sign != ch){
                temp += ch;
            }
            if(sign == ch){
                cnt ++;
                if(cnt == 2){
                    temp += " ";
                }
            }
        }
        return temp;
    }
}
