package tmax_2023;

import java.util.*;

/*
* https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/?envType=daily-question&envId=2023-11-10
* 1743. Restore the Array From Adjacent Pairs
*
* */
public class Leetcode_1743 {

    public static void main(String[] args) {
        int[][][] adjacentPair = {{{2,1},{3,4},{3,2}},{{4,-2},{1,4},{-3,1}},{{10000,-10000}}};

        for (int i = 0; i < 3; i++) {
            int[] ans = solution(adjacentPair[i]);
            for (int j : ans) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static List<Integer> result = new ArrayList<>();
    private static int[] solution(int[][] adjacentPair) {
        // Map 이용해서 그래프 만들기
        // value 길이가 1이면 끝 점이다. -> dfs 시작점이다.
        // 연결된 점이 있으면 탐색하고 result 에 추가

        // map 초기화
        map.clear();
        result.clear();
        for (int[] arr : adjacentPair) {
            map.computeIfAbsent(arr[0], integer -> new ArrayList<>()).add(arr[1]);
            map.computeIfAbsent(arr[1], integer -> new ArrayList<>()).add(arr[0]);
        }

        // start 세팅
        int start = 0;
        for (int n : map.keySet()) {
            if (map.get(n).size() == 1) {
                start = n;
                break;
            }
        }

        // dfs
        dfs(start, 10001);

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static void dfs(int curr, int prev) {
        result.add(curr);
        for (int n : map.get(curr)) {
            // n == prev 인 경우는 해당 prev에서 n으로 온 경우 따라서 탐색하지 않은 n != prev를 조건으로 함
            if (n != prev) {
                dfs(n, curr);
            }
        }
    }

}
