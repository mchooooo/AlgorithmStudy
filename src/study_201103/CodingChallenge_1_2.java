package study_201103;

public class CodingChallenge_1_2 {

    public static void main(String[] args){
        int n = 100000000;
        String t = "";

        while(n>3){
            t+=n%3;
            n=n/3;
        }
        if(n!=0) t+=n;
        int product = 1;
        int answer = 0;
        for(int i = t.length()-1; i >= 0; i--){
            answer += Integer.parseInt(t.charAt(i)+"")*product;
            product *= 3;

        }

        System.out.println(answer);
    }

}
