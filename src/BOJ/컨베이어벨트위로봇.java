package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/20055
 */
public class 컨베이어벨트위로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int k = Integer.parseInt(inp[1]);
        boolean[] robot = new boolean[n+1];

        inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }


        int answer = 1;

        while (true) {
            if (k <= countBelt(arr)) {
                break;
            }

            int[] temp = new int[arr.length];
            temp[0] = arr[arr.length - 1];
            System.arraycopy(arr, 0, temp, 1, arr.length - 1);

            boolean[] robotTemp = new boolean[n+1];
            robotTemp[0] = robot[n - 1];
            System.arraycopy(robot, 0, robotTemp, 1, n - 1);

            if (robotTemp[n - 1]) {
//                temp[n-1] -= 1;
                robotTemp[n - 1] = false;
//                if (k <= countBelt(temp)) {
//                    break;
//                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (robotTemp[i]) {
                    if (!robotTemp[i+1] && temp[i+1] >= 1) {
                        robotTemp[i+1] = robotTemp[i];
                        robotTemp[i] = false;
                        temp[i+1] -= 1;
                        if (k <= countBelt(temp)) {
                            break;
                        }
                    }
                }

                if (robotTemp[i+1] && i + 1 == n - 1) {
                    robotTemp[i+1] = false;
//                    temp[i+1] -= 1;
                }

            }

            if (k <= countBelt(temp)) {
                break;
            }

            if (temp[0] >= 1) {
                robotTemp[0] = true;
                temp[0] -= 1;
            }

            if (k <= countBelt(temp)) {
                break;
            }

            System.arraycopy(temp, 0, arr, 0, arr.length);
            System.arraycopy(robotTemp, 0, robot, 0, robot.length);
            answer++;

        }

        System.out.println(answer);

    }

    private static int countBelt(int[] arr) {
        long count = Arrays.stream(arr).filter(value -> value == 0).count();
        return (int) count;
    }
}
