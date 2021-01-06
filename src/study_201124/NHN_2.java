package study_201124;

import java.util.ArrayList;
import java.util.List;

public class NHN_2 {

    public static void main(String[] args){
        int page = 1;
        int[] broken = {0,1,2,3,4,5,6,7,8,9};

        if(broken.length == 10){
            System.out.println(Math.abs(page-100));
        }

        int[] unbroken = new int[10];
        List<Integer> unbrokenList = new ArrayList<Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        for(int i = 0; i < unbroken.length; i++){
            unbroken[i]=i;
        }
        for(int i = 0; i < broken.length; i++){
            unbroken[broken[i]] = -1;
        }

        for(int i = 0; i < unbroken.length;i++){
            if(unbroken[i] != -1){
                unbrokenList.add(unbroken[i]);
            }
        }


        answerList.add(Math.abs(100-page));

        String strPage = page+"";
        String strAnswer = "";
        for(int i = 0; i < strPage.length(); i++){
            int num = Integer.parseInt(strPage.charAt(i)+"");
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for(int j = 0; j < unbrokenList.size(); j++){
                if(min > Math.abs(num-unbrokenList.get(j))){
                    min = Math.abs(num-unbrokenList.get(j));
                    temp = unbrokenList.get(j);
                }

            }
            strAnswer += (temp+"");

        }

        int secondAnswer = Math.abs(Integer.parseInt(strAnswer) - page) + strAnswer.length();
        answerList.add(secondAnswer);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < unbrokenList.size(); i++) {
            if(max < unbrokenList.get(i)){
                max = unbrokenList.get(i);
            }
            if(min > unbrokenList.get(i)) {
                min = unbrokenList.get(i);
            }
        }

        if(page>9) {
            String maxAnswer = "";
            for (int i = 0; i < strPage.length() - 1; i++) {
                maxAnswer += (max + "");
            }
            int thirdAnswer = Math.abs(Integer.parseInt(maxAnswer) - page) + maxAnswer.length();
            answerList.add(thirdAnswer);
        }
        String minAnswer = "";
        for(int i = 0; i < strPage.length()+1; i++){
            minAnswer += (min+"");
        }

        int fourthAnswer = Math.abs(Integer.parseInt(minAnswer) - page) + minAnswer.length();
        answerList.add(fourthAnswer);

        min = Integer.MAX_VALUE;

        for(int i = 0; i < answerList.size(); i++) {
            if (min > answerList.get(i)) {
                min = answerList.get(i);
            }
        }

        System.out.println(min);
    }

}
