package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int temp = arr[i];
            for (int j = 0; j < n; j++) {
                if (cnt == temp && answer[j] == 0) {
                    answer[j] = i + 1;
                    break;
                }

                if (answer[j] == 0) {
                    cnt++;
                }


            }
        }

        for (int ans : answer) {
            System.out.print(ans + " ");
        }

    }
}
