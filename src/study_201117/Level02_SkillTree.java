package study_201117;

import java.util.ArrayList;
import java.util.List;

public class Level02_SkillTree {
    public static void main(String[] args){
        String skill = "CBD";
        String[] skill_trees={"BACDE","CBADF","AECB","BDA"};

        int answer = 0;

        for(int i =0 ; i < skill_trees.length; i++){
            String temp = "";
            for(int j = 0; j < skill_trees[i].length(); j++){
                if(skill.contains(skill_trees[i].charAt(j)+"")){
                    temp += skill_trees[i].charAt(j);
                }
            }
            skill_trees[i] = temp;
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < skill.length(); i++){
            list.add(skill.substring(0,skill.length()-i));
        }
        list.add("");
        System.out.println(list);

        for(int i = 0; i < skill_trees.length; i++){
            if(list.contains(skill_trees[i])) answer++;

        }

    }
}
