package study_201117;

public class Level01_SecretMap {

    public static void main(String[] args){
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};
        String[] answer = new String[n];

        String[] str1 = new String[n];
        String[] str2 = new String[n];

        String str = "";
        String s = "";
        for(int i = 0; i < n; i++){
            int a = arr1[i];
            int b = arr2[i];
            while(a > 0){
                int t = a % 2;
                if(t == 0) str += 0+"";
                else str += t+"";
                a /= 2;
            }

            while(b > 0){
                int t = b % 2;
                if(t == 0) s += 0+"";
                else s += t+"";
                b /= 2;
            }

            while(str.length() != n){
                str += 0+"";
            }
            while(s.length() != n){
                s += 0+"";
            }
            String temp = "";
            String temp1 = "";
            for(int j = n-1; j >= 0; j--){
                char c = str.charAt(j);
                char ch = s.charAt(j);
                temp += c+"";
                temp1 += ch+"";

            }

            str1[i] = temp;
            str2[i] = temp1;
            str = "";
            s="";
        }
        String ans = "";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(str1[i].charAt(j) == '0' && str2[i].charAt(j) == '0'){
                    ans += " ";
                }else{
                    ans += "#";
                }
            }
            answer[i] = ans;
            ans = "";
        }

        for(int i = 0; i < n; i++){
            System.out.println(answer[i]);
        }

    }
}
