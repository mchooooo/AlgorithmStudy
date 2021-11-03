package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_9020 {
    static List<Integer> list = new ArrayList<>();
    static List<Integer> sol = new ArrayList<>();
    static int[] answer;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0){
            int num = sc.nextInt();
            addPrime(num);
            answer = new int[2];
            answer[0] = 0;
            answer[1] = 10000;
            comb(num,0);
            System.out.println(answer[0] + " " + answer[1]);
            list.clear();
            sol.clear();

            n--;
        }

    }

    public static void comb(int target, int idx){

        if(sol.size() == 2){
            if(sol.get(0) + sol.get(1) == target){
                if(answer[1] - answer[0] > sol.get(1) - sol.get(0)){
                    answer[0] = sol.get(0);
                    answer[1] = sol.get(1);
                    return;
                }
                return;
            }
            return;
        }

        for(int i = idx; i < list.size(); i++){
            sol.add(list.get(i));
//            System.out.println("list.get(i) = " + list.get(i));
//            System.out.println("sol.size() = " + sol.size());
            comb(target, i);
            sol.remove(list.get(i));
        }

    }

    public static void addPrime(int n){
        for(int i = 2; i < n; i++){
            if(isPrime(i)) list.add(i);
        }
    }

    public static boolean isPrime(int n){
        if(n==2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;

    }

}
