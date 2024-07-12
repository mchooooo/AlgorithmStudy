package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    public static void main(String[] args) {
        String[][] b = {
            {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."},
            {".D.R", "....", ".G..", "...D"}
        };

        for (int i = 0; i < b.length ; i++) {
            System.out.println(solution(b[i]));
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int m;
    public static int solution(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();
        Node robot = null;
        Node goal = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    robot = new Node(i,j,0);
                } else if (board[i].charAt(j) == 'G') {
                    goal = new Node(i,j,0);
                }
            }
        }

        answer = bfs(board, robot, goal);


        return answer;
    }

    private static int bfs(String[] board, Node robot, Node goal) {
        boolean[][] visit = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(robot);
        visit[robot.x][robot.y] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.x == goal.x && curr.y == goal.y) {
                return curr.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                while (isValid(nx, ny) && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                System.out.println(nx + " / " + ny);
                if (visit[nx][ny] || (curr.x == nx && curr.y == ny)) {
                    continue;
                }

                visit[nx][ny] = true;

                q.add(new Node(nx, ny, curr.cnt + 1));


            }

        }

        return -1;

    }

    private static boolean isValid (int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

}
