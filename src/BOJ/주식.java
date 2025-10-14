package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/11501
 */
public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int cnt = Integer.parseInt(br.readLine());
            int[] arr = new int[cnt];
            int[] sorted = new int[cnt];
            String[] inp = br.readLine().split(" ");
            for (int i = 0; i < inp.length; i++) {
                int temp = Integer.parseInt(inp[i]);
                arr[i] = temp;
                sorted[i] = temp;
            }

//            Arrays.sort(sorted);
//            int pos = sorted.length - 1;
//            int count = 0;
//            int money = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] == sorted[pos]) {
//                    money += count * arr[i];
//                    pos--;
//                    count = 0;
//                } else {
//                    money -= arr[i];
//                    count++;
//                }
//            }
//
//            System.out.println(Math.max(money, 0));

            int max = arr[arr.length - 1];
            long sum = 0;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (max > arr[i]) {
                    sum += max - arr[i];
                } else {
                    max = arr[i];
                }
            }

            System.out.println(sum);

        }
    }
}
