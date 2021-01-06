package study_201124;

import java.util.ArrayList;
import java.util.List;

public class NHN_1 {

    public static void main(String[] args){
        int[] goods = {49,49,49};
        List<Integer> list = new ArrayList<Integer>();
        int answer = 0;

        if(goods[0] >= 50) {
            list.add(goods[0] - 10);
            goods[0] = -1;
        }
        if(goods[1] >= 50) {
            list.add(goods[1] - 10);
            goods[1] = -1;
        }
        if(goods[2] >= 50){
            list.add(goods[2] - 10);
            goods[2] = -1;
        }
        if(goods[0]+goods[1] >= 50 && goods[0] != -1 && goods[1] != -1){
            list.add(goods[0]+goods[1] - 10);
            goods[0] = -1;
            goods[1] = -1;
        }
        if(goods[1]+goods[2] >= 50 && goods[1] != -1 && goods[2] != -1){
            list.add(goods[1]+goods[2] - 10);
            goods[1] = -1;
            goods[2] = -1;
        }
        if(goods[0]+goods[2] >= 50 && goods[0] != -1 && goods[2] != -1){
            list.add(goods[0]+goods[2] - 10);
            goods[0] = -1;
            goods[2] = -1;
        }
        if(goods[0]+goods[1]+goods[2] >= 50 &&goods[0]!=-1 && goods[1] != -1 && goods[2] != -1){
            list.add(goods[0]+goods[1]+goods[2] - 10);
            goods[0] = -1;
            goods[1] = -1;
            goods[2] = -1;
        }
        for(int i = 0; i < goods.length; i++){
            if(goods[i] != -1){
                list.add(goods[i]);
            }
        }

        for(int price : list){
            answer += price;
        }

        if(list.size()==0){
            answer = goods[0]+goods[1]+goods[2];
        }

        System.out.println(answer);



    }

}
