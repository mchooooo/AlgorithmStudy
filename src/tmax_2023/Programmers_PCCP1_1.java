package tmax_2023;
import java.util.*;


/*
* https://school.programmers.co.kr/learn/courses/15008/lessons/121683?language=java
* [PCCP 모의고사 #1] 1번 - 외톨이 알파벳
* */
public class Programmers_PCCP1_1 {

    public static void main(String[] args) {
        String[] input_string = {"edeaaabbccd", "eeddee", "string", "zbzbz"};
        for (int i = 0; i < input_string.length; i++) {
            System.out.println(solution(input_string[i]));
        }
    }

    public static String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input_string.length(); i++) {
            char ch = input_string.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) continue;
            int cnt = map.get(c);
            int idx = input_string.indexOf(c);
            for (int i = idx; i < input_string.length(); i++) {
                if (c == input_string.charAt(i)) {
                    cnt--;
                } else {
                    if (cnt != 0) sb.append(c);
                    break;
                }
            }
        }
        if (sb.length() == 0) return "N";
        char[] arr = new char[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            arr[i] = sb.charAt(i);
        }
        Arrays.sort(arr);
        sb.setLength(0);
        for (char c : arr) {
            sb.append(c);
        }


        return sb.toString();
    }
}
