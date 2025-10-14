package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int x = Integer.parseInt(inp[0]);
        int y = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        int[] arr = new int[y];
        for (int i = 0; i < y; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        int left = 0;
        int right = y - 1;
        int maxLeft = arr[left];
        int maxRight = arr[right];
        int water = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, arr[left]);
                water += maxLeft - arr[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, arr[right]);
                water += maxRight - arr[right];
            }
        }
        System.out.println(water);

//        int[] leftMax = new int[y];
//        int[] rightMax = new int[y];
//
//        int max = 0;
//
//        for (int i = 0; i < y; i++) {
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//
//            leftMax[i] = max;
//        }
//
//        max = 0;
//        for (int i = y - 1; i >= 0; i--) {
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//
//            rightMax[i] = max;
//        }
//
//        int answer = 0;
//        for (int i = 1; i < y - 1; i++) {
//            answer += Math.min(leftMax[i], rightMax[i]) - arr[i];
//        }
//
//        System.out.println(answer);


    }
}
