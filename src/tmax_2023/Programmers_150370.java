package tmax_2023;

import java.util.*;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/150370
* 개인정보 수집 유효기간
* 구현
* */
public class Programmers_150370 {

    public static void main(String[] args) {
        String[] today = {"2022.05.19", "2020.01.01"};
        String[][] terms = {{"A 6", "B 12", "C 3"}, {"Z 3", "D 5"}};
        String[][] privacies = {{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}, {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}};

        for (int i = 0; i < today.length; i++) {
            int[] result = solution(today[i], terms[i], privacies[i]);
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
        }

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] res = null;
        List<Integer> resultList = new ArrayList<>();
        // 1. 날짜 계산 -> 동의 일자 (privacy[0]) + terms 계산 -> privacy 수집 기간이 끝나는 날 계산
        // 2. 유효기간 검사 -> 오늘 넘었는지 검사
        // 결과 add

        Map<String, String> termsMap = convStringArrToMap(terms);


        for (int i = 0; i < privacies.length; i++) {
            String endPrivacy = addPrivacyToTerms(privacies[i].split(" ")[0], termsMap.get(privacies[i].split(" ")[1]));
            int result = chkToday(today, endPrivacy);
            if (result < 0) {
                resultList.add(i + 1);
            }
        }

        res = new int[resultList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resultList.get(i);
        }

        return res;
    }

    private static Map<String, String> convStringArrToMap(String[] terms) {
        Map<String, String> termsMap = new HashMap<>();
        for (String t : terms) {
            String[] splitTerms = t.split(" ");
            termsMap.put(splitTerms[0], splitTerms[1]);
        }

        return termsMap;
    }

    private static String addPrivacyToTerms(String privacy, String terms) {
        String[] splitPrivacy = privacy.split("\\.");
        int year = Integer.parseInt(splitPrivacy[0]);
        int month = Integer.parseInt(splitPrivacy[1]);
        int day = Integer.parseInt(splitPrivacy[2]);
        int term = Integer.parseInt(terms);

        // 약관은 달 단위
        month += term;
        day -= 1;
        // 예외 처리
        // month 가 12를 넘는 경우
        if (month > 12) {
            year += month / 12;
            month %= 12;
        }

        if (month == 0) {
            month = 12;
            year -= 1;
        }

        // day 가 0인 경우
        if (day == 0) {
            day = 28;
            month -= 1;
        }

        if (month == 0) {
            month = 12;
            year -= 1;
        }

        return year + "." + month + "." + day;
    }

    private static int chkToday(String today, String endPrivacy) {
        String[] splitToday = today.split("\\.");
        String[] splitEndPrivacy = endPrivacy.split("\\.");

        // 약관 기간이 남았다면 일로 바꾸고 (약관 마지막 날 - 오늘) 하면 양수가 나와야 함
        int todayInt = (Integer.parseInt(splitToday[0]) * 12 * 28) + (Integer.parseInt(splitToday[1]) * 28) + Integer.parseInt(splitToday[2]);
        int endPrivacyInt = (Integer.parseInt(splitEndPrivacy[0]) * 12 * 28) + (Integer.parseInt(splitEndPrivacy[1]) * 28) + Integer.parseInt(splitEndPrivacy[2]);

        return endPrivacyInt - todayInt;

    }


}
