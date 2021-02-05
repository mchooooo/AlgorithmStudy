package study_210205;

import java.util.HashSet;
import java.util.Set;

public class Programmers_42839 {

    public static void main(String[] args){
        String number = "011";
        Set<Integer> set = new HashSet<>();
        permutation("",number,set);
        int result = 0;

        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            System.out.println(a);
            set.remove(a);
            if(a==2) result++;
            if(a%2!=0 && isPrime(a)){
                result++;
            }
        }
        System.out.println(result);

    }

    public static void permutation(String prefix, String str, Set<Integer> set){
        int n = str.length();
        if(!prefix.equals("")){
            set.add(Integer.parseInt(prefix));
        }

        for(int i = 0; i < n; i++){
            permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n),set);
        }

    }
    public static boolean isPrime(int n){
        if(n <= 1 ) return false;
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

}
