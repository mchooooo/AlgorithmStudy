package study_210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14888 {

    public static int[] op;
    static int[] nums;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] sp = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(sp[i]);
        }

        // + - * /
        op = new int[4];
        sp = br.readLine().split(" ");
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(sp[i]);
        }
        dfs(op[0],op[1],op[2],op[3],1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int plus, int minus, int product, int divide, int cnt, int sum){
        if(cnt == N){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        if(plus>0){
            dfs(plus-1, minus,product, divide, cnt+1, sum + nums[cnt]);
        }
        if(minus>0){
            dfs(plus, minus-1,product, divide, cnt+1, sum - nums[cnt]);
        }
        if(product>0){
            dfs(plus, minus,product-1, divide, cnt+1, sum * nums[cnt]);
        }
        if(divide>0){
            dfs(plus, minus,product, divide-1, cnt+1, sum / nums[cnt]);
        }

    }

}
