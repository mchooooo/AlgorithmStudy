package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 탑 {
    static class Tower {
        int height;
        int idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        String[] inp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        Stack<Tower> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int h = arr[i];

            while (!st.isEmpty() && st.peek().height < h) {
                st.pop();
            }

            if (!st.isEmpty()) {
                answer[i] = st.peek().idx;
            } else {
                answer[i] = 0;
            }

            st.push(new Tower(h, i + 1));

        }

        for (int i : answer) {
            System.out.print(i + " ");
        }



    }
}
