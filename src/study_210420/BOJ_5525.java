package study_210420;

import java.util.Scanner;

public class BOJ_5525 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int answer = 0;
        char[] arr = s.toCharArray();
        int patternCnt = 0; // `IOI` 패턴 연속 횟수
        for (int i = 1; i < M - 1; i++) {
            if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
                patternCnt++;
                if (patternCnt == N) {
                    patternCnt--;
                    answer++;
                }
                i++;
            } else patternCnt = 0;
        }

        System.out.println(answer);

    }
}
