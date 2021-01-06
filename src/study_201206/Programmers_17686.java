package study_201206;

import java.util.ArrayList;
import java.util.List;

//프로그래머스 레벨2 [3차] 파일명 정렬
public class Programmers_17686 {

    public static void main(String[] args){
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        int len= files.length;

        List<Node> list = new ArrayList<Node>();

        for(int i = 0; i < len; i++){
            Node n = new Node();
            String number = "";
            for(int j = 0; j < files[i].length();j++){
//                if()
            }

        }


    }

}
class Node{
    String header;
    int number;
    int idx;
}