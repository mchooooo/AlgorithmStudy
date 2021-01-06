package study_201231;

public class SkillCheck01 {


    public static void main(String[] args){
        int[] nums = {1,2,7,6,4};
        int answer=0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
//                    System.out.println(nums[i]+nums[j]+nums[k]);
                    if(check(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);

    }

    public static boolean check(int num){
        for(int i = 2; i < num; i++){
            if(num%i==0) {

                return false;
            }
        }
        return true;
    }

}
