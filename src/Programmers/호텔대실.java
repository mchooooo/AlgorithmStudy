package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/155651
* */
public class 호텔대실 {
    public static void main(String[] args) {

        String[][][] bookTime = {
            {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}},
            {{"09:10", "10:10"}, {"10:20", "12:20"}},
            {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(solution(bookTime[i]));
        }

    }

    public static int solution(String[][] book_time) {
        int result = 0;
        int[][] bookTime = new int[book_time.length][2];
        int[] arr = new int[1450];

        for (int i = 0; i < book_time.length; i++) {
            String[] split = book_time[i][0].split(":");
            bookTime[i][0] = (Integer.parseInt(split[0]) * 60) + (Integer.parseInt(split[1]));
            split = book_time[i][1].split(":");
            bookTime[i][1] = (Integer.parseInt(split[0]) * 60) + (Integer.parseInt(split[1]) + 10);
        }

//        Arrays.sort(bookTime, Comparator.comparingInt(o -> o[0]));
//        for (int[] ints : bookTime) {
//            System.out.println(ints[0] + " / " + ints[1]);
//        }

        for (int i = 0; i < bookTime.length; i++) {
            arr[bookTime[i][0]] += 1;
            arr[bookTime[i][1]] -= 1;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
            result = Math.max(result, arr[i]);

        }

        return result;
    }

    private static int clearRoom(int time) {
        time += 10;
        time = time % 100 >= 60 ? time + 40 : time;

        return time;

    }

}
