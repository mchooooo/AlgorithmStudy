package study_210418;
/*
* 풍선터트리기
* 투포인터를 활용
* 질문하기 참고
* */
public class Programmers_68646 {

    public static void main(String[] args){
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};

        int n = a.length;
        int left = 0;
        int right = n-1;
        int lMin = a[left];
        int rMin = a[right];
        int answer = 1;

        while(left < right){
            if(lMin > rMin){
                left++;
                if(a[left] < lMin){
                    answer++;
                }
                lMin = Math.min(lMin, a[left]);
            }else{
                right--;
                if(a[right] < rMin){
                    answer++;
                }
                rMin = Math.min(rMin, a[right]);
            }
        }

        System.out.println(answer);


    }

}
