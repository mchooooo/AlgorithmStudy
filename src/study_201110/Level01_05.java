package study_201110;

public class Level01_05 {

    public static void main(String[] args){
        int n = 8;
        int[] lost = {4,5};
        int[] reserve={5,6};

        int answer = n-lost.length;

        for(int i = 0; i < lost.length;i++){
            for(int j = 0; j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    lost[i]=Integer.MAX_VALUE;
                    reserve[j]=Integer.MIN_VALUE;
                }
            }
        }


        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                int greedy = lost[i] - reserve[j];
                if(greedy>=-1 && greedy<=1){
                    answer++;
                    reserve[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        System.out.println(answer);

    }

}
