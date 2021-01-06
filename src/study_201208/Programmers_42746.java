package study_201208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//프로그래머스 레벨2 가장 큰 수
public class Programmers_42746 {

    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9};
        String answer ="";

        Node[] nodes = new Node[numbers.length];

        int cnt = 0;
        int a = 0;
        for (int i = 0; i < numbers.length; i++) {
            String str = "";
            for(int j = 0; str.length() < 4; j++){
                str += numbers[i]+"";
            }
            Node n = new Node();
            n.num = Integer.parseInt(str);
            n.idx = i;
            nodes[i] = n;
        }

        for(int i = 0; i < nodes.length; i++){
            for(int j = i; j < nodes.length; j++){
                if(nodes[i].num < nodes[j].num){
                    int temp = nodes[i].idx;
                    nodes[i].idx = nodes[j].idx;
                    nodes[j].idx = temp;
                }
            }
        }

        for(int i = 0; i < numbers.length; i++){
            answer += numbers[nodes[i].idx];
        }
        System.out.println(answer);

    }
}

class Node{
    int num;
    int idx;
}
