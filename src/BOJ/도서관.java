package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
https://www.acmicpc.net/problem/1461
 */
public class 도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int result = 0;
        int max = 0;
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        input = br.readLine().split(" ");

        for (String s : input) {
            int position = Integer.parseInt(s);
            if (position > 0) {
                posList.add(position);
                continue;
            }

            negList.add(-position);
        }

        posList.sort(Collections.reverseOrder());
        negList.sort(Collections.reverseOrder());
        int posIdx = 0;
        int negIdx = 0;

        for (posIdx = 0; posIdx < posList.size(); posIdx += m) {
            max = Math.max(max, posList.get(posIdx));
            result += posList.get(posIdx) * 2;
        }

        for (negIdx = 0; negIdx < negList.size(); negIdx += m) {
            max = Math.max(max, negList.get(negIdx));
            result += negList.get(negIdx) * 2;
        }


        if (posIdx < posList.size()) {
            result += posList.get(posList.size() - 1) * 2;
        }

        if (negIdx < negList.size()) {
            result += negList.get(negList.size() - 1) * 2;
        }



        System.out.println(result - max);

    }
}
