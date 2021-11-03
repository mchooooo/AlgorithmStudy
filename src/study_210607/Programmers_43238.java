package study_210607;

import java.util.Arrays;

/*
* 입국심사
* 이분탐색으로
* 최소랑 최대시간을 잡고
* 중앙값에서 몇명처리하는지 확인
* */
public class Programmers_43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = (long)times[times.length-1] * n;

        while(left<=right){
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for(int i = 0; i < times.length; i++){
                cnt += mid / times[i];
            }

            if(cnt >= n){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(answer);

    }
}
