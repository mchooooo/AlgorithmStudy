package study_201030;

public class Programmers_Lev2_1 {

    public static void main(String[] args){
        String str = "1 2 3 4";
        String[] s = str.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < s.length; i++){
            int num = Integer.parseInt(s[i]);
            if(min > num){
                min = num;
            }
            if(max < num){
                max = num;
            }
        }
        System.out.print(min+" "+max);
    }
}
