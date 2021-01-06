package study_200212_1032;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> list= new ArrayList<String>();
        for(int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        for(int i =0 ; i < list.size(); i++){
            char[][] chars = new char[i][list.get(i).length()];
            chars[i]=list.get(i).toCharArray();
            System.out.println(chars[i]);
        }

    }

}
