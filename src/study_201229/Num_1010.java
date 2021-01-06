package study_201229;

        import java.util.Scanner;

public class Num_1010 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            long result = 0;
            if(a > b-a) {
                result = cal(b, b - a);
            }else{
                result = cal(b,a);
            }
            System.out.println(result);

            n--;
        }
    }

    public static long cal(int n, int m){
        long a = 1;
        for(int i = n; i > n-m; i--){
            a *= i;
        }
        long b = 1;
        for(int i = 1; i <=m; i++){
            b *= i;
        }
        return a/b;
    }
}
