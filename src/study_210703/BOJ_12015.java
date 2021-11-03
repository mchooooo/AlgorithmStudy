package study_210703;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_12015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if(list.get(list.size()-1) < num) list.add(num);
            else{
                int left = 0;
                int right = list.size()-1;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(list.get(mid) >= num){
                        right = mid;
                    }else{
                        left = mid+1;
                    }
                }
                list.set(right, num);
            }
        }
        System.out.println(list.size()-1);

    }
}
