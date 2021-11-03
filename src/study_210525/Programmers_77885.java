package study_210525;

public class Programmers_77885 {
    public static void main(String[] args) {
        long[] numbers = {9, 7};
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            if(num % 2 == 0) answer[i] = num+1;
            else{
                long lastZero = ((num+1) & (-num));
                answer[i] = ((num | lastZero) & (~(lastZero>>1)));
            }
        }


    }

}
