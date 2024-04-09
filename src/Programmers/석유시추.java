package Programmers;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/250136
* */
public class 석유시추 {
    public static void main(String[] args) {
        int[][][] land = {{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}
        , {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}};

        for (int i = 0; i < 2; i++) {
            System.out.println(solution(land[i]));
        }
    }
    static int[] result;
    static boolean[] chkLine;
    static boolean[][] visit;
    static int[][] arr;
    static int n;
    static int m;
    static int max = 0;
    public static int solution (int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        arr = land;
        result = new int[m];
        chkLine = new boolean[m];
        visit = new boolean[n][m];



        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[j][i] == 1 && !visit[j][i]) {
                    dfs(j, i);

                    for (int k = 0; k < m; k++) {
                        if(chkLine[k]) {
                            result[k] += max;
                            chkLine[k] = false;
                        }
                    }
                    max = 0;
                }
            }
        }

        for (int i : result) {
            answer = Math.max(answer, i);
        }


        return answer;
    }

    public static void dfs (int x, int y) {
        if (visit[x][y]) return;
        if (arr[x][y] != 1) return;
        visit[x][y] = true;
        chkLine[y] = true;
        max++;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isValid(nx, ny)) continue;

            dfs(nx,ny);
        }

//        max = Math.max(num, max);


    }
    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }
}
