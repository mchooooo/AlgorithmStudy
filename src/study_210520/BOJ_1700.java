package study_210520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
* 멀티탭 스케줄링
* */
public class BOJ_1700 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        int[] arr = new int[k];
        info = br.readLine().split(" ");
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(info[i]);
        }

        boolean[] use = new boolean[101];
        int cnt = 0;
        int put = 0;
        for(int i = 0; i < k; i++){
            int elec = arr[i];

            if(!use[elec]){
                if(put < n) { //멀티탭 사용중이 아니라면
                    use[elec] = true;
                    put++;
                }else{ //멀티탭에 공간이 없는 경우
                    List<Integer> list = new ArrayList<>();
                    for(int j = i; j < k; j++){
                        if(use[arr[j]] && !list.contains(arr[j])){
                            list.add(arr[j]);
                        }
                    }
                    if(list.size() != n){ //리스트 사이즈랑 n이랑 다르면 더이상 사용하지 않는 제품 존재
                        for(int j = 0; j < use.length; j++){
                            if(use[j] && !list.contains(j)){
                                use[j] = false;
                                break;
                            }
                        }
                    }else{
                        int remove = list.get(list.size()-1);
                        use[remove] = false;
                    }
                    use[elec] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }

}
