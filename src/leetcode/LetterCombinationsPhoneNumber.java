package leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String st = "4";
        Double d = Double.parseDouble(st);
        Math.round(d);
        BigDecimal[] bd = new BigDecimal[4];
        bd[0] = BigDecimal.valueOf(4);
        bd[1] = BigDecimal.valueOf(5);

        String[] ex = {"23", "", "2"};
        for (int i = 0; i < ex.length; i++) {
            List<String> result = solution(ex[i]);
            
            for (String s : result) {
                System.out.print(s + " ");
            }
            
            System.out.println();
        }
    }

    private static List<String> solution(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] phoneMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        backtracking("", digits, phoneMap, result);

        return result;
    }

    private static void backtracking(String comb, String nextDigit, String[] phoneMap, List<String> result) {
        if (nextDigit.length() == 0) {
            result.add(comb);
        } else {
            String letter = phoneMap[nextDigit.charAt(0) - '0'];
            for (char ch : letter.toCharArray()) {
                backtracking(comb + ch, nextDigit.substring(1), phoneMap, result);
            }
        }
    }
}
