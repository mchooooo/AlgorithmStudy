package study_210419;

public class Programmers_67256 {
    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        int[][] map = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        String hand ="right";

        String answer = "";

        int[] leftHand = new int[2];
        int[] rightHand = new int[2];

        for(int i = 0; i < numbers.length; i++){
            int temp = numbers[i];
            if(temp == 1 || temp == 4 || temp == 7){
                leftHand = map[temp];
                answer += "L";
            }else if(temp == 3 || temp == 6 || temp == 9){
                rightHand = map[temp];
                answer +="R";
            }else{
                int[] d = map[temp];
                if(Math.abs(d[0] - leftHand[0]) + Math.abs(d[1] - leftHand[1]) < Math.abs(d[0] - rightHand[0]) + Math.abs(d[1] - rightHand[1]) ){
                    answer += "L";
                    leftHand = map[temp];
                }else if(Math.abs(d[0] - leftHand[0]) + Math.abs(d[1] - leftHand[1]) > Math.abs(d[0] - rightHand[0]) + Math.abs(d[1] - rightHand[1])){
                    answer += "R";
                    rightHand = map[temp];
                }else{
                    if(hand.equals("right")) {
                        answer += "R";
                        rightHand = map[temp];
                    }else{
                        answer += "L";
                        leftHand = map[temp];
                    }
                }
            }
        }
        System.out.println(answer);



    }
}
