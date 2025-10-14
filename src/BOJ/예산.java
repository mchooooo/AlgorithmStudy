package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sp = br.readLine().split(" ");
        int sum = 0;
        int requestMax = 0;
        int requestMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sp[i]);
            sum += arr[i];
            requestMax = Math.max(arr[i], requestMax);
            requestMin = Math.min(arr[i], requestMin);
        }

        int max = Integer.parseInt(br.readLine());

        if (sum <= max) {
            System.out.println(requestMax);
            System.exit(0);
        }




        int answer = 0;
        while (requestMin <= requestMax) {
            int mid = requestMin + (requestMax - requestMin) / 2;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += Math.min(mid, arr[i]);
            }


//            System.out.println(mid+" / "+temp);

            if (temp == max) {
                answer = mid;
                break;
            } else if (temp < max) {
                requestMin = mid + 1;
                answer = mid;
            } else {
                requestMax = mid - 1;
            }



        }

        System.out.println(answer);

    }
}
