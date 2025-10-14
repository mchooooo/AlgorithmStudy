package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/20006
 */
public class 랭킹전대기열 {

    static class Room {
        int minLevel;
        int maxLevel;
        int full;
        List<People> waiting;

        Room(int level, String name, int full) {
            this.minLevel = level - 10;
            this.maxLevel = level + 10;
            this.full = full;
            waiting = new ArrayList<>();
            waiting.add(new People(level, name));
        }

        public boolean checkEnter(int level) {
            if (waiting.size() >= full) {
                return false;
            }

            return level >= minLevel && level <= maxLevel;
        }





    }

    static class People implements Comparable<People>{
        int level;
        String name;
        People(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(People p) {
            return name.compareTo(p.name);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int p = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            inp = br.readLine().split(" ");
            int level = Integer.parseInt(inp[0]);
            String name = inp[1];
            if (i == 0) {
                rooms.add(new Room(level, name, m));
                continue;
            }
            boolean chk = false;
            for (Room r : rooms) {
                if (r.checkEnter(level)) {
                    r.waiting.add(new People(level, name));
                    chk = true;
                    break;
                }
            }

            if (!chk) {
                rooms.add(new Room(level, name, m));
            }

        }

        for (Room r : rooms) {
            Collections.sort(r.waiting);
        }

        for (Room r : rooms) {
            if (r.waiting.size() == m) {
                System.out.println("Started!");
                for (People people : r.waiting) {
                    System.out.println(people.level+" " + people.name);
                }
            } else {
                System.out.println("Waiting!");
                for (People people : r.waiting) {
                    System.out.println(people.level + " " + people.name);
                }
            }
        }


    }
}
