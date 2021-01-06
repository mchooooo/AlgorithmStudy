package study_201201;

//프로그래머스 레벨2 조이스틱
public class Programmers_42860 {

    public static void main(String[] args){
        String name = "JEROEN";

        int len = name.length();
        int answer = 0;
        char[] nameChars = name.toCharArray();
        int cnt = 0;
        int i =0;
        //a b c d e f g h i j k l m n o p q r s t u v w x y z
        while(true){
            if(cnt >= len-1) break;
            char ch = nameChars[i];
            int AtoCh = Math.abs('A'-ch);
            int ZtoCh = Math.abs('Z'-ch);
            System.out.println("############# / "+i);
            if(ch!='A' && ch !='a'){
                if(AtoCh < ZtoCh ){
                    answer += AtoCh;
                    System.out.println("1111"+ch+"1 / "+ AtoCh);
                }else if(AtoCh > ZtoCh ){
                    answer += (ZtoCh+1);
                    System.out.println("2222"+ch+"2 / "+ ZtoCh);
                }
                nameChars[i]='a';
                cnt++;


            }
            System.out.println(answer);
            if(nameChars[i+1]== 'A'){
                int rightCnt = 0;
                int leftCnt = 0;
                int temp = 0;
                for(int j = i; j < len; j++){

                    if(nameChars[j] != 'A' && nameChars[j] !='a'){
                        break;
                    }
                    rightCnt++;
                }
                for(int j = len-1; j >= 0; j++){

                    if(nameChars[j] != 'A' && nameChars[j] !='a'){
                        break;
                    }
                    leftCnt++;
                    temp = j;
                }
                leftCnt += (i+1);



                if(leftCnt > rightCnt){
//                    if(AtoCh < ZtoCh ){
//                        answer += AtoCh;
//                        System.out.println("3333"+ch+"1 / "+ AtoCh);
//                    }else if(AtoCh > ZtoCh ){
//                        answer += (ZtoCh+1);
//                        System.out.println("4444"+ch+"2 / "+ ZtoCh);
//                    }
//                    nameChars[i]='a';
                    answer += rightCnt;
                    i = rightCnt;
                    System.out.println("rightPos = "+i);
                }else{
//                    if(AtoCh < ZtoCh ){
//                        answer += AtoCh;
//                        System.out.println(ch+"1 / "+ AtoCh);
//                    }else if(AtoCh > ZtoCh ){
//                        answer += (ZtoCh+1);
//                        System.out.println(ch+"2 / "+ ZtoCh);
//                    }
//                    nameChars[i]='a';
                    answer += leftCnt;
                    i = len-1 - temp;
                    System.out.println("leftPos 2 = "+i);
                }
                // J A A C D

            }




        }
        System.out.println(answer);

    }

}
