package study_201118;

public class Level01_12901 {
    //프로그래머스 레벨1 2016년
    public static void main(String[] args){
        int a = 5;
        int b = 24;
        String answer = "";
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int[] months = {0,31,29,31,30,31,30,31,31,30,31,30,31};

        int calDay = 0;

        for(int i = 1; i < a; i++){
            calDay += months[i];
        }

        calDay = (calDay + b - 1) % 7;
        System.out.println(day[calDay]);

    }
}
