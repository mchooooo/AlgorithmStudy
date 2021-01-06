package study_201111;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//크레인 인형뽑기
public class Level01_02 {

    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        List<Stack<Integer>> list = new ArrayList<Stack<Integer>>();
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < board.length; i++){
            for(int j = board[0].length-1; j >= 0; j--){
                if(board[j][i]!=0) {
                    st.push(board[j][i]);
                }
            }
            list.add(st);
            st = new Stack<>();

        }
        int answer = 0;
        Stack<Integer> save = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int a = moves[i]-1;
            if(!list.get(a).isEmpty()) {

                if (!save.isEmpty() && list.get(a).peek() == save.peek()) {
                    answer++;
                    list.get(a).pop();
                    save.pop();
                } else {
                    save.push(list.get(a).pop());
                }
            }
        }
        answer *= 2;
        System.out.println("ans "+answer);
    }

}
