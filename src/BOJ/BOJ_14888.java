package BOJ;

import java.util.Scanner;

public class BOJ_14888 {

    static int[] arr;
    static int[] op; // +, -, *, /
    static int min;
    static int max;
    static int n;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        op = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++){
            op[i] = sc.nextInt();
        }

        dfs(arr[0], 0, 1);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int sum, int cnt, int idx){
        if(cnt == n-1){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                if(i == 0){
                    op[i]--;
                    dfs(sum + arr[idx], cnt+1, idx+1);
                    op[i]++;
                }else if(i == 1){
                    op[i]--;
                    dfs(sum - arr[idx], cnt+1, idx+1);
                    op[i]++;
                }else if(i == 2){
                    op[i]--;
                    dfs(sum * arr[idx], cnt+1, idx+1);
                    op[i]++;
                }else{
                    op[i]--;
                    dfs(sum / arr[idx], cnt+1, idx+1);
                    op[i]++;
                }
            }
        }

    }
}
