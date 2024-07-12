package Programmers;

public class 덧칠하기 {
    public static void main(String[] args) {
        int[] n = {8,5,4};

        int[] m = {4,4,1};

        int[][] s = {
            {2, 3, 6},
            {1,3},
            {1,2,3,4}
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], m[i], s[i]));
        }

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;

        int start = section[0] + m - 1; // 5


        while(start < section[section.length - 1]) {
            for (int i : section) {
                if (i > start) {
                    start = i + m - 1;
                    answer++;
                    break;
                }
            }


        }


        return answer;
    }

}
