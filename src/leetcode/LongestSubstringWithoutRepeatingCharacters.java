package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        int n = 5;
        int[][] arr = new int[5][5];
        int max = 0;
        int temp = 0;
        for (int i = 0; i < n - 2; n++) {
            for (int j = 0; j < n - 2; j++) {
                for (int k = i; k < i + 2; k++) {
                    for (int w = j; w < j + 2; w++) {
                        if (arr[k][w] == 1) {
                            temp++;
                        }
                    }
                }
                max = Math.max(max, temp);
            }
        }

        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("au"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int pos = 0;
        Set<Character> set = new HashSet<>();

        while (pos < s.length() - 1) {
            for (int j = pos; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    ans = Math.max(ans, set.size());
                    pos = j;
                    set.clear();
                    break;
                }

                set.add(c);


            }

        }

        return ans;
    }

}
