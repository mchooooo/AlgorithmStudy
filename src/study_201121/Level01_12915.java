package study_201121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//프로그래머스 레벨1 문자열 내 맘대로 정렬하기
public class Level01_12915 {

    public static void main(String[] args){

        String[] strings = {"abce", "abcd", "cdx"};
        int n = 1;
        strings[1] = strings[1].toLowerCase();
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);

                if(c1==c2) return o1.compareTo(o2);

                else return c1-c2;
            }
        });

    }

}
