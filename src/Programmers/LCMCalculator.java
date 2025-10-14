package Programmers;

public class LCMCalculator {

    // 최대공약수를 구하는 메서드 (유클리드 알고리즘 사용)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 두 수의 최소공배수를 구하는 메서드
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    // 여러 수의 최소공배수를 구하는 메서드
    public static int lcm(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = lcm(result, numbers[i]);
        }
        return result;
    }

    // 메인 메서드 - 예제 실행
    public static void main(String[] args) {
        int[] numbers = {24, 18, 12};  // 정렬되지 않은 배열

        int result = lcm(numbers);
        System.out.println("The LCM of the given numbers is " + result);
    }
}
