package study_210513;

public class BOJ_4673 {
    static boolean[] selfNum = new boolean[10101];
    public static void main(String[] args) {

        for(int i = 1; i < 10001; i++){
            d(i);
        }
        for(int i = 1; i < 10001; i++){
            if(!selfNum[i]) System.out.println(i);
        }

    }
    public static void d(int number){
        int self = number;
        while(number != 0){
            self += (number % 10);
            number /= 10;
        }
        selfNum[self] = true;
    }
}
