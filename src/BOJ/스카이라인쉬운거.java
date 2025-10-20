package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1863
 */
public class 스카이라인쉬운거 {
    static class Building {
        int x;
        int y;

        Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Building> buildings = new ArrayList<>();

        String[] inp;

        for (int i = 0; i < n; i++) {
            inp = br.readLine().split(" ");
            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            buildings.add(new Building(x, y));
        }

        // 핵심 아이디어
        // 스택의 top의 y 값과  현재 y 값을 확인
        // top > y : 건물 끝, > 아닐때 까지 pop하고 개수만큼 answer++
        // top == y : 같은 건물로 생각, 아무 행동 x
        // top < y : 새로운 건물 확인, y > 0 이면 stack push

        int answer = 0;
        Stack<Building> st = new Stack<>();
        st.push(new Building(0, 0)); //높이 0 건물 초기값으로 push
        for (Building building : buildings) {
            if (st.peek().y > building.y) {
                while (st.peek().y > building.y) {
                    st.pop();
                    answer++;
                }
            }

            if (st.peek().y == building.y) {
                continue;
            }

            if (st.peek().y < building.y && building.y > 0) {
                st.push(building);
            }
        }

        while (st.peek().y != 0) {
            st.pop();
            answer++;
        }

        System.out.println(answer);

    }
}
