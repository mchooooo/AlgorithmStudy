package tmax_2023;

/*
* https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/description/?envType=daily-question&envId=2023-11-08
* 2849. Determine if a Cell Is Reachable at a Given Time
* */
public class Leetcode_2849 {
    public static void main(String[] args) {
        int[] sx = {2,3};
        int[] sy = {4,1};
        int[] fx = {7,7};
        int[] fy = {7,3};
        int[] t = {6,3};

        for (int i = 0; i < 2; i++) {
            System.out.println(solution(sx[i], sy[i], fx[i], fy[i], t[i]));
        }
    }

    private static boolean solution(int sx, int sy, int fx, int fy, int t) {
        // 8방향으로 움직일 수 있음
        // 시작점에서 끝점으로 이동하는 최단거리를 구하고 t랑 비교
        // 최단 거리 구하기 -> fx - sx , fy - sy 두 값중 최소값으로 대각 이동 후 남은 값 이동한 거리
        // 시작점과 끝점이 동일하고 t == 1이면 false, 1초에 한 곳은 움직여야 하는데 왔다 갔다하면 최소 2이다.
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        int xMin = Math.abs(sx - fx);
        int yMin = Math.abs(sy - fy);
        int dist = Math.min(xMin, yMin) + Math.abs(xMin - yMin);
        return t >= dist;

    }
}
