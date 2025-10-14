package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        int len = inp.length();

        int cntA = 0;
        int cntB = 0;

        for (int i = 0; i < len; i++) {
            if (inp.charAt(i) == 'a') {
                cntA++;
            }
        }

        String cycle = inp + inp;
        for (int i = 0; i < cntA; i++) {
            if (cycle.charAt(i) == 'b') {
                cntB++;
            }
        }

        int min = cntB;

        for (int i = 1; i < len; i++) {
            if (cycle.charAt(i - 1) == 'b') {
                cntB--;
            }

            if (cycle.charAt(i + cntA - 1) == 'b') {
                cntB++;
            }

            min = Math.min(min, cntB);
        }

        System.out.println(min);


    }
}
