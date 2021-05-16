package study_210428;

public class Programmers_64062 {
    static int[] stones;
    static int k;
    public static void main(String[] args) {
        stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        k = 3;
        int answer = 0;
        //바이너리 서치 최댓값과 최소의 중간값을 계산하고 되면 오른쪽 안되면 왼쪽
        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        for(int i : stones){
            right = Math.max(i,right);
            left = Math.min(i,left);
        }

//        if(right == left) System.out.println(left);

        answer = search(stones,k,left,right);
        System.out.println(answer);
    }
    public static int search(int[] stones, int k, int min, int max){
        while(min < max){
            int mid = (min+max) / 2;
//            System.out.println(mid);
            if(calc(stones, k, mid)){
                min = mid;
            }else{
                max = mid - 1;
            }
        }
        return min;
    }
    public static boolean calc(int[] stones, int k, int mid){
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - mid < 0) cnt++;
            else cnt = 0;
            if(cnt == k) return false;
        }
        return true;
    }


}
