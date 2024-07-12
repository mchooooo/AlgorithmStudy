package Programmers;

import java.util.*;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/176962
* */
public class 과제진행하기 {
    static class Assn {
        String subject;
        int startTime;
        int work;
        int endTime;

        public Assn(String[] plan) {
            this.subject = plan[0];
            // 시작 시간은 분으로 표시 계산을 간단하게 하기 위해
            String[] time = plan[1].split(":");
            this.startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            // 걸린 시간
            this.work = Integer.parseInt(plan[2]);

            this.endTime = startTime + work;
        }

    }
    public static void main(String[] args) {
        String[][][] p = {
            {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}},
            {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}},
            {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}
        };

        for (int i = 0; i < p.length; i++) {
            String[] temp = solution(p[i]);
            for (String s : temp) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        Assn[] assns = new Assn[plans.length];
        Stack<Assn> st = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            assns[i] = new Assn(plans[i]);
        }

        Arrays.sort(assns, Comparator.comparingInt(o -> o.startTime));

        for (int i = 0; i < assns.length; i++) {
            if (st.isEmpty()) {
                st.push(assns[i]);
                continue;
            }

            Assn curr = st.peek();

            if (curr.startTime + curr.work <= assns[i].startTime){
                assnPop(st, curr.startTime, assns[i], result);
            } else {
                curr.work = curr.work + curr.startTime - assns[i].startTime;
            }

            st.push(assns[i]);

        }


        while (!st.isEmpty()) {
            result.add(st.pop().subject);
        }


        return result.toArray(new String[0]);
    }

    private static void assnPop(Stack<Assn> st, int currTime, Assn newAssn, List<String> result) {
        if (st.isEmpty()) {
            return;
        }

        Assn currAssn = st.peek();

        if (currTime + currAssn.work <= newAssn.startTime) {
            result.add(st.pop().subject);
            assnPop(st, currTime + currAssn.work, newAssn, result);
        } else {
            currAssn.work = currTime + currAssn.work - newAssn.startTime;
        }
    }
}
