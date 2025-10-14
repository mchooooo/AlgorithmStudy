package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2304
 */
public class 창고다각형 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.x, n.x);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String[] inp = br.readLine().split(" ");
            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            nodes[i] = new Node(x, y);
        }

        Arrays.sort(nodes);

        int maxIdx = 0;
        int maxHeight = nodes[0].y;
        for (int i = 0; i < nodes.length; i++) {
            if (maxHeight <= nodes[i].y) {
                maxIdx = i;
                maxHeight = nodes[i].y;
            }
        }

        int idx = 0;
        for (int i = 0; i <= maxIdx; i++) {
            if (nodes[idx].y <= nodes[i].y) {
                answer += (nodes[i].x - nodes[idx].x) * nodes[idx].y;
                idx = i;
            }
        }

        idx = nodes.length - 1;
        for (int i = nodes.length - 1; i >= maxIdx; i--) {
            if (nodes[idx].y <= nodes[i].y) {
                answer += (nodes[idx].x - nodes[i].x) * nodes[idx].y;
                idx = i;
            }
        }

        answer += nodes[maxIdx].y;

        System.out.println(answer);

    }
}
