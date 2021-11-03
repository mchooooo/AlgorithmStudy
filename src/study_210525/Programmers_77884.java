package study_210525;

public class Programmers_77884 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        int sum = 0;
        for(int i = left; i <= right; i++){
            if(Math.sqrt(i) == Math.floor(Math.sqrt(i))) sum -= i;
            else sum += i;
        }

        System.out.println(sum);
    }
}
