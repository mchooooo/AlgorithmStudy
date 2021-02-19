package study_210219;

/*
* 1초마다 음식을 먹고 넘어감
* 해당 음식을 다먹었으면 넘어감
* k초 만큼 반복문 -> food_time[k%len]
* 정확성 통과 효율성 실패..
* */
public class Programmers_42891 {
    public static void main(String[] args){
        int[] food_times = {4,2,3,6,7,1,5,8};
        long k = 16;
        int answer = 0;
        int len = food_times.length;

        int sum = 0;
        int pos = 0;
        for(int i : food_times){
            sum += i;
        }

        if(sum <= k) answer = -1;

        for(int i = 0; i < k; i++){

            if(food_times[pos%len]>0){

                food_times[pos%len] -= 1;
            }else if(food_times[pos%len] == 0){
                //다음 음식 먹을 위치 찾기
                while(true){
                    pos++;
                    if(food_times[pos%len] > 0){
                        food_times[pos%len] -= 1;
                        break;
                    }
                }
            }
            pos++;

        }
        while(true){
            if(food_times[pos%len]>0){
                answer = pos%len;
                break;
            }
            pos++;
        }
        answer = pos%len;
        System.out.println(answer+1);
    }
}
