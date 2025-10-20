package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http://acmicpc.net/problem/2138
 */
public class 전구와스위치 {

    static int[] source;
    static int[] target;

    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        source = new int[N];
        target = new int[N];
        int answer = -1;

        for (int i = 0; i < 2; i++) {
            String inp = br.readLine();
            for (int j = 0; j < inp.length(); j++) {
                if (i == 0) {
                    source[j] = Integer.parseInt(String.valueOf(inp.charAt(j)));
                } else {
                    target[j] = Integer.parseInt(String.valueOf(inp.charAt(j)));
                }
            }
        }

        if (isSame(source, target)) {
            System.out.println(0);
            return;
        }

        //핵심 로직 curr[i-1] != target[i-1] 이면 i번째 스위치를 누름
        int[] curr = arrCopy(N);

        //1번 시나리오 0번 스위치를 누르고 돌린다.
        int firstCnt = 1;
        press(0, curr);
        for (int i = 1; i < N; i++) {
            if (curr[i - 1] != target[i - 1]) {
                press(i, curr);
                firstCnt++;
            }
        }

        if (!isSame(curr, target)) {
            firstCnt = Integer.MAX_VALUE;
        }

        //2번 시나리오 0번 스위치를 누르지 않고 돌린다.
        int secondCnt = 0;
        curr = arrCopy(N);

        for (int i = 1; i < N; i++) {
            if (curr[i - 1] != target[i - 1]) {
                press(i, curr);
                secondCnt++;
            }
        }

        if (!isSame(curr, target)) {
            secondCnt = Integer.MAX_VALUE;
        }

        if (firstCnt == Integer.MAX_VALUE && secondCnt == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = Math.min(firstCnt, secondCnt);
        }
        System.out.println(answer);

    }

    private static int[] arrCopy(int N) {
        int[] curr = new int[N];
        for (int i = 0; i < N; i++) {
            curr[i] = source[i];
        }

        return curr;
    }

    private static void press(int n, int[] arr) {
        if (n == 0) {
            arr[0] = reverse(arr[n]);
            arr[1] = reverse(arr[n + 1]);
            return;
        } else if (n == arr.length - 1) {
            arr[n] = reverse(arr[n]);
            arr[n - 1] = reverse(arr[n - 1]);
            return;
        }

        arr[n - 1] = reverse(arr[n - 1]);
        arr[n] = reverse(arr[n]);
        arr[n + 1] = reverse(arr[n + 1]);
    }

    private static int reverse(int num) {
        return num == 0 ? 1 : 0;
    }

    private static boolean isSame(int[] a, int[] b) {
        boolean chk = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return chk;
    }
}
