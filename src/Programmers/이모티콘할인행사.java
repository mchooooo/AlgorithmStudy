package Programmers;

public class 이모티콘할인행사 {

    private static final int[] DISCOUNT_RATE = {10, 20, 30, 40};
    private static int subscriber;
    private static int totalPrice;
    public static void main(String[] args) {
        int[][][] u = {
            {{40, 10000}, {25,10000}},
            {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}
        };

        int[][] e = {
            {7000, 9000},
            {1300, 1500, 1600, 4900}
        };

        for (int i = 0; i < u.length; i++) {
            int[] answer = solution(u[i], e[i]);
            for (int j : answer) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    private static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        getDiscountRate(users, emoticons, 0, new int[emoticons.length]);

        answer[0] = subscriber;
        answer[1] = totalPrice;
        return answer;
    }

    private static void getDiscountRate(int[][] users, int[] emoticons, int idx, int[] discount) {
        if (idx == emoticons.length) {
            getSolution(users, emoticons, discount);
        } else {
            for (int rate : DISCOUNT_RATE) {
                discount[idx] = rate;
                getDiscountRate(users, emoticons, idx + 1, discount);
            }


        }
    }

    private static void getSolution(int[][] users, int[] emoticons, int[] discount) {

        int ePlus = 0;
        int total = 0;

        for (int[] user : users) {
            int price = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= discount[i]) {
                    price += emoticons[i] * (int)(100 - discount[i]) / 100;
                }
            }

            // 이모티콘 구매 결과
            if (price >= user[1]) {
                ePlus++;
                price = 0;
            }

            total += price;

        }

        // 최종 결과 세팅
        if (ePlus > subscriber) {
            subscriber = ePlus;
            totalPrice = total;
        } else if (ePlus == subscriber) {
            totalPrice = Math.max(total, totalPrice);
        }

    }
}
