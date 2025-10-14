package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");

        int N = Integer.parseInt(inp[0]);
        int d = Integer.parseInt(inp[1]);
        int k = Integer.parseInt(inp[2]);
        int c = Integer.parseInt(inp[3]);

        int[] arr = new int[N];
        int[] count = new int[d+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int unique = 0;

        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) {
                unique++;
            }

            count[arr[i]]++;
        }

        int max = unique;

        if (count[c] == 0) {
            max++;
        }

        for (int i = 1; i < N; i++) {
            int remove = arr[(i - 1) % N];
            count[remove]--;

            if (count[remove] == 0) {
                unique--;
            }

            int add = arr[(i + k - 1) % N];
            if (count[add] == 0) {
                unique++;
            }
            count[add]++;

            int temp = unique;

            if (count[c] == 0) {
                temp++;
            }

            max = Math.max(max, temp);

        }

        System.out.println(max);

    }
}
