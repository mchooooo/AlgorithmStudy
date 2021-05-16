package study_210430;

import java.util.PriorityQueue;

public class Programmers_77485 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[][] arr = new int[rows][columns];
        int[] answer = new int[queries.length];
        int num = 1;
        for(int i =0 ; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = num++;
            }
        }

        for(int i = 0; i < queries.length;i++){
            rotate(arr,queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            answer[i] = pq.poll();
            pq.clear();
        }




    }

    public static void rotate(int[][] arr, int x1, int y1, int x2, int y2){
        //arr 복사
        int[][] copyArr = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                copyArr[i][j] = arr[i][j];
            }
        }
        x1 -= 1;
        x2 -= 1;
        y1 -= 1;
        y2 -= 1;
        //4번 나누어서 회전
        // 1. -> 방향 /  [x1][y1] -> [x1][y2]
        for(int i = y1; i < y2; i++){
            arr[x1][i+1] = copyArr[x1][i];
            pq.add(copyArr[x1][i]);
        }
        // 2. 아래 / [x1][y2] -> [x2][y2]
        for(int i = x1; i < x2; i++){
            arr[i+1][y2] = copyArr[i][y2];
            pq.add(copyArr[i][y2]);
        }
//        // 3. <- 방향 / [x2][y2] -> [x2][y1]
        for(int i = y2; i > y1; i--){
            arr[x2][i-1] = copyArr[x2][i];
            pq.add(copyArr[x2][i]);
        }
//        // 4. 위 / [x2][y1] -> [x1][y1]
        for(int i = x2; i > x1; i--){
            arr[i-1][y1] = copyArr[i][y1];
            pq.add(copyArr[i][y1]);
        }

    }

    public static void print(int[][] arr, int rows, int columns){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }
    }
}