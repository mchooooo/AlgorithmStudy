package Programmers;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/250137
* */
public class 붕대감기 {
    public static void main(String[] args) {
        int[][] b = {{5,1,5},{3,2,7},{4,2,7},{1,1,1}};
        int[] h = {30,20,20,5};
        int[][][] a = {{{2,10},{9,15},{10,5},{11,5}},{{1,15},{5,16},{8,6}},{{1,15},{5,16},{8,6}},{{1,2},{3,2}}};

        for (int i = 0; i < 4; i++) {
            System.out.println(solution(b[i], h[i], a[i]));
        }
    }

    public static int solution (int[] bandage, int health, int[][] attacks) {
        int success = 1;
        int finalAttackTime = attacks[attacks.length - 1][0];
        int attackIdx = 0;
        int fullHp = health;
        for (int i = 1; i <= finalAttackTime; i++) {
            if (health <= 0) {
                return -1;
            }

            if (attacks[attackIdx][0] == i) {
                health -= attacks[attackIdx][1];
                attackIdx++;
                success = 1;
            } else {
                if (success == bandage[0]) {
                    health += bandage[1] + bandage[2];
                    if (health > fullHp) {
                        health = fullHp;
                    }
                    success = 1;
                } else {
                    health += bandage[1];
                    if (health > fullHp) {
                        health = fullHp;
                    }
                    success++;
                }
            }

        }

        return health == 0 ? -1 : health;
    }
}
