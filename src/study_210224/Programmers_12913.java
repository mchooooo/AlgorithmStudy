package study_210224;

/*
* 땅따먹기
* 2차원 배열에서 한 행씩 내려오면서 같은 열을 연속으로 밟을 수 없음
* dp로 풀어보자
* */
public class Programmers_12913 {
    public static void main(String[] args){
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer =0;

        for(int i = 1; i < land.length; i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][2],Math.max(land[i-1][3],land[i-1][0]));
            land[i][2] += Math.max(land[i-1][3],Math.max(land[i-1][0],land[i-1][1]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }


        for(int i = 0; i < 4; i++){
            answer = Math.max(land[land.length-1][i],answer);
        }
        System.out.println(answer);
    }
}
