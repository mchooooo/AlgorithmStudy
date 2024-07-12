package Programmers;

import java.util.*;

public class 방금그곡 {
    public static void main(String[] args) {

        String[] m = {"ABCDEFG"	, "CC#BCC#BCC#BCC#B", "ABC","ABCD","ABC", "C#C#C#", "ABC","ABC","ABC","C#C","ABCDEFG","CCB","ABC"};
        String[][] musicinfos = {
            {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"},
            {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},
            {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"},
            {"12:00,12:00,TEST,ABCD", "13:00,13:05,CH,ABCD"},
            {"04:00,04:03,NAME,ABC#D"},
            {"03:00,03:30,FOO,C#", "04:00,04:08,BAR,D#"},
            {"12:00,12:06,HELLO,ABC#ABC#ABC"},
            {"12:00,12:10,HELLO,ABC#ABC#ABC"},
            {"12:04,13:00,HELLO,ABC#ABC#ABC"},
            {"12:00,12:06,HELLO,C#C#CC#"},
            {"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"},
            {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"},
            {"23:50,00:00,TT,ABC"}
        };

        for (int i = 0; i< m.length; i++) {
            System.out.println(solution(m[i], musicinfos[i]));
        }
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String replaceMelody = replaceMelody(m);
        String[] replaceMusic = new String[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {

            String[] split = musicinfos[i].split(",");

            // musicinfos 멜로디 replace
            replaceMusic[i] = replaceMelody(split[3]);

            // 음악이 재생된 시간 계산 (분)
            int min = calcMusicPlayTime(split[0], split[1]);

            if (min > replaceMusic[i].length()) {
                int repeatLen = min - replaceMusic[i].length();
                // 노래 멜로디보다 긴 경우 반복해서 붙이기
                for (int j = 0; j < repeatLen; j++) {
                    replaceMusic[i] += replaceMusic[i].charAt(j % (repeatLen));
                }
            } else if (min < replaceMusic[i].length()) {
                // 노래 멜로디보다 재생된 시간이 짧은 경우 짜르기?
                replaceMusic[i] = replaceMusic[i].substring(0, min);
            }
        }

        // 비교해야함..
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < replaceMusic.length; i++) {

            if (replaceMusic[i].length() >= replaceMelody.length()) {
                for (int j = 0; j < replaceMusic[i].length() - replaceMelody.length() + 1; j++) {
                    String temp = replaceMusic[i].substring(j, j + replaceMelody.length());
                    if (temp.equals(replaceMelody)) {
                        resultList.add(i);
                        break;
                    }
                }
            }
        }


        if (resultList.size() == 1) {
            answer = musicinfos[resultList.get(0)].split(",")[2];
        } else if (resultList.size() > 1) {
            // max time 구해?
            int max = -1;
            for (int i : resultList) {
                int playTime = calcMusicPlayTime(musicinfos[i].split(",")[0], musicinfos[i].split(",")[1]);
                max = Math.max(max, playTime);
            }

            List<Integer> tempList = new ArrayList<>();

            for (int i : resultList) {
                int playTime = calcMusicPlayTime(musicinfos[i].split(",")[0], musicinfos[i].split(",")[1]);
                if (max == playTime) {
                    tempList.add(i);
                }
            }

            if (tempList.size() == 1) {
                answer = musicinfos[tempList.get(0)].split(",")[2];
            } else if (tempList.size() > 1) {
                // 먼저 재생된 곡 찾기
                String[] temp = new String[tempList.size()];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = musicinfos[tempList.get(i)];
                }
                Arrays.sort(temp);
                answer = temp[0].split(",")[2];

            }

        } else {
            answer = "(None)";
        }

        return answer;
    }

    private static String replaceMelody(String m) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m.length(); i++) {
            st.push(m.charAt(i));
            if (m.charAt(i) == '#') {
                st.pop();
                st.pop();
                st.push(Character.toLowerCase(m.charAt(i-1)));
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }

    private static int calcMusicPlayTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        if (!startTime[0].equals("00") && endTime[0].equals("00")) {
            endTime[0] = "24";
        }

        return ((Integer.parseInt(endTime[0]) * 60) + Integer.parseInt(endTime[1]))
            - ((Integer.parseInt(startTime[0]) * 60) + Integer.parseInt(startTime[1]));
    }
}
