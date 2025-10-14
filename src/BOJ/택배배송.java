package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/5972
 */
public class 택배배송 {

//    static class Edge {
//        int start;
//        int end;
//        int cost;
//
//        public Edge(int start, int end, int cost) {
//            this.start = start;
//            this.end = end;
//            this.cost = cost;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);

//        int[] answer = new int[N + 1];
        int[][] arr = new int[N + 1][N + 1];

        for (int[] row : arr) {
            Arrays.fill(row, 10000);
        }

        for (int i = 0; i < M; i++) {
            inp = br.readLine().split(" ");
            int s = Integer.parseInt(inp[0]);
            int e = Integer.parseInt(inp[1]);
            int c = Integer.parseInt(inp[2]);

            arr[s][e] = c;
            arr[e][s] = c;
        }

        // 플로이드-워샬 알고리즘
        // i - j 비용보다 i - k - j, k를 경유했을 때 더 작으면 갱신
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        System.out.println(arr[1][N]);
//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < N + 1; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }


    }
}
