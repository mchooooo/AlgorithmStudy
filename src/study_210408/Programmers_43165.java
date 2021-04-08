package study_210408;

/*
* 프로그래머스 타겟넘버
* dfs로 타겟넘버 찾으면 cnt ++
* */
public class Programmers_43165 {
    static int count = 0;
    static int[] numbers = {1,1,1,1,1};
    static int target = 3;

    public static void main(String[] args){


        dfs(0, 0);
        System.out.println(count);

    }
    public static void dfs(int idx, int sum){

        if(idx == numbers.length){
            if(sum == target){
                count++;
            }
            return;

        }
        int x = numbers[idx];
        dfs(idx+1, sum+x);
        dfs(idx+1, sum-x);
    }
}
