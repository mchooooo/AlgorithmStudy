package study_201118;


import java.util.Stack;

public class Level01_12906 {
    //프로그래머스 레벨1 같은숫자는싫어
    public static void main(String[] args){
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            if(stack.peek()!=arr[i]){
                stack.push(arr[i]);
            }
        }

        answer = new int[stack.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = stack.get(i);
        }

        for(int i : answer){
            System.out.println(i);
        }


    }
}
