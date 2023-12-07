package tmax_2023;

/*
* https://leetcode.com/problems/count-number-of-homogenous-substrings/description/?envType=daily-question&envId=2023-11-09
*1759. Count Number of Homogenous Substrings
* */
public class Leetcode_1759 {

    public static void main(String[] args) {
        String[] s = {"abbcccaa", "xy", "zzzzz"};

        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }

    }

    private static int solution(String s) {
        // 연속하는 캐릭터 값의 합
        // 누적 합으로 구함
        // 이전 캐릭터랑 현재 캐릭터 값이 같으면 ++ 연산
        // 다르면 sum 값 1 로 초기화
        // aaa 인 경우
        // 인덱스 0, sum = 1 -> answer = answer + sum = 1
        // 인덱스 1, sum = 2 -> answer = answer + sum = 3
        // 인덱스 2, sum = 3 -> answer = answer + sum = 6

        int answer = 0;
        int sum = 0;
//        final int MOD = 100000007;  10^9 + 7 나눈 나머지 값으로 해야하는데 이렇게 하면 하나 케이스 통과 못 함;;
        final int MOD = (int) (1e9 + 7); // 1e9 + 7 로 하면 통과

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sum = 1;
            } else if (s.charAt(i) == s.charAt(i - 1)) {
                sum++;
            } else {
                sum = 1;
            }

            answer = (answer + sum) % MOD;

        }

        return answer;
    }

}
