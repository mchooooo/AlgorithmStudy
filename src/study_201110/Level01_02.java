package study_201110;

import java.util.Arrays;

public class Level01_02 {

    public static void main(String[] args){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = new int[commands.length];
        int t = 0;
        for(int i = 0; i < commands.length; i++){

            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] arr = new int[end-start+1];
            for(int w = 0; w<end-start+1;w++){
                arr[w] = array[start-1+w];
            }
            Arrays.sort(arr);
            t = arr[k-1];

            answer[i]=t;
        }
        for(int i = 0; i < answer.length;i++){
            System.out.println(answer[i]);
        }

    }

}
