package study_201117;

public class Level02_StockPrice {

    public static void main(String[] args){
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] > prices[j]){
                    System.out.println("i = "+i);
                    System.out.println("j = "+j);
                    answer[i] = j-i;
                    break;
                }else{
                    System.out.println("i = "+ i);
                    answer[i] = prices.length-i-1;
                }
            }
        }

        answer[answer.length-1] = 0;
        for(int i = 0; i <prices.length; i++){
            System.out.println(answer[i]);
        }
    }

}

