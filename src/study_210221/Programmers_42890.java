package study_210221;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 후보키
* 가능한 모든 조합 만든 후 확인...
* 비트마스킹??
* */
public class Programmers_42890 {
    public static void main(String[] args){
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int answer = 0;

        int row = relation.length;
        int col = relation[0].length;

        List<Integer> result = new ArrayList<>();
        //컬럼으로 만들 수 있는 조합을 비트마스킹으로 표현
        for(int i = 0; i < (1<<col); i++){
            Set<String> set = new HashSet<>();
            for(int j = 0; j < row; j++){
                StringBuilder sb = new StringBuilder();

                for(int k = 0; k < col; k++){
                    System.out.println(i&(1<<k));
                    if((i&(1<<k))>0){
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size()==row && check(result,i)){
                result.add(i);
            }
        }
        answer = result.size();
        System.out.println(answer);

    }
    public static boolean check(List<Integer> list, int bit){
        for(int i = 0; i < list.size(); i++){
            if((list.get(i)&bit) == list.get(i)) return false;
        }
        return true;
    }
}
