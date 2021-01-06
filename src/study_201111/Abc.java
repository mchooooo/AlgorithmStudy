package study_201111;

import org.omg.CORBA.NameValuePair;

public class Abc {

    public static void main(String[] args){
        System.out.println(factorial(10));
        int result = 0;
        int m =3;
        int w =9;

        result = factorial(m+w) / (factorial(3) * factorial(m+w-3));
        System.out.println(result);

    }

    public static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
}
