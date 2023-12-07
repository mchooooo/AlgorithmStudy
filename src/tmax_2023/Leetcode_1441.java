package tmax_2023;
import java.util.*;

/*
* https://leetcode.com/problems/build-an-array-with-stack-operations/description/?envType=daily-question&envId=2023-11-03
* 1441. Build an Array With Stack Operations
* 
* */
public class Leetcode_1441 {

    public static void main(String[] args) {
        int[] n = {3, 3, 4};
        int[][] target = {{1, 3}, {1, 2, 3}, {1, 2}};

        for (int i = 0; i < 3; i++) {
            List<String> strings = buildArray(target[i], n[i]);
            strings.forEach(System.out::println);
            System.out.println();
        }

    }

    public static List<String> buildArray(int[] target, int n) {
        int end = target[target.length -1];

        List<String> result = new ArrayList<>();
        int compare = 1;
        for (int i = 0; i < target.length; i++) {
            int num = target[i];
            if (compare == end) {
                result.add("Push");
                break;
            }


            if (compare < num) {
                while (compare != num) {
                    result.add("Push");
                    result.add("Pop");
                    compare++;
                }
            }

            if (compare == num) {
                result.add("Push");
                compare++;
            }

        }



        return result;

    }
}
