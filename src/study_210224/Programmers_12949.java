package study_210224;

/*
* 행렬의 곱셈
* 반목문으로 곱하는 공식을 잘 세워보자
* */
public class Programmers_12949 {
    public static void main(String[] args){
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};

        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[0].length; j++){
                for(int k = 0; k <arr2[0].length; k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                    //     0  0          0  0         0  0
                    //     0  1          0  0         0  1
                    //     0  0          0  1         1  0
                    //     0  1          0  1         1  1
                }
            }

        }
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
