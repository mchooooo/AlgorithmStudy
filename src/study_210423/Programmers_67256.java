package study_210423;

public class Programmers_67256 {
    public static void main(String[] args){

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        //0 1 2 3 4 5 6 7 8 9 왼손 오른손
        int[][] phone = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        String answer = "";
        int[] curLeft = phone[10];
        int[] curRight = phone[11];

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                curLeft = phone[numbers[i]];
                answer += "L";
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                curRight = phone[numbers[i]];
                answer += "R";
            }else{
                //거리 계산 거리가 같으면 주로 사용하는 손으로
                int leftDis = Math.abs(curLeft[0] - phone[numbers[i]][0]) + Math.abs(curLeft[1] - phone[numbers[i]][1]);
                int rightDis = Math.abs(curRight[0] - phone[numbers[i]][0]) + Math.abs(curRight[1] - phone[numbers[i]][1]);
                if(leftDis == rightDis){
                    if(hand.equals("right")){
                        answer +="R";
                        curRight = phone[numbers[i]];
                    }else{
                        answer +="L";
                        curLeft = phone[numbers[i]];
                    }
                }else{
                    if(leftDis > rightDis){
                        curRight = phone[numbers[i]];
                        answer+="R";
                    }else{
                        curLeft = phone[numbers[i]];
                        answer+="L";
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
