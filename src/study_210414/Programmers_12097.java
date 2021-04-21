package study_210414;

/*
* 거스름돈
* dfs로 거스름돈 줄 수 있으면 ++
* */
public class Programmers_12097 {
    static  int answer = 0;
    static int[] money = {1,2,5};


    public static void main(String[] args){
        int n = 5;

        dfs(n,0);
        System.out.println(answer);
    }

    public static void dfs(int now,int index){

        for(int i=index;i<money.length;i++) {
            if(now-money[i]>0){
                dfs(now-money[i],i);
            }
            else if( now - money[i]==0) {
                answer++;
                return;
            }
        }

    }

}
