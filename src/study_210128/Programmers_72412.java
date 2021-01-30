package study_210128;

public class Programmers_72412 {
    //효율성 실패 ...
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = new int[query.length];
        People[] people = new People[info.length];
        for(int i = 0; i < info.length; i++){
            String[] temp = info[i].split(" ");
            People p = new People(temp[0],temp[1],temp[2],temp[3],temp[4]);
            people[i] = p;
        }
        People[] detailCondition = new People[query.length];
        for(int i = 0; i < query.length; i++){
            String[] detail = query[i].split(" ");
            detailCondition[i] = new People(detail[0],detail[2],detail[4],detail[6],detail[7]);
        }

        for(People p : people){
            System.out.print(p.language+" / "+p.job+" / "+p.career+" / "+p.food+" / "+p.score+"\n");
        }
        System.out.println();
        int sum = 0;
        for(People p : detailCondition){
            System.out.print(p.language+" / "+p.job+" / "+p.career+" / "+p.food+" / "+p.score+"\n");
        }
        for(int i = 0; i < detailCondition.length; i++){
            System.out.println("i = "+i);
            for(int j = 0; j < people.length;j++){
                if(detailCondition[i].language.equals("-") || (detailCondition[i].language.equals(people[j].language))){
                    System.out.println("language = " + people[j].language);
                    if(detailCondition[i].job.equals("-") || detailCondition[i].job.equals(people[j].job)){
                        System.out.println("job = " + people[j].job);
                        if(detailCondition[i].career.equals("-") || detailCondition[i].career.equals(people[j].career)){
                            System.out.println("career = " + people[j].career);
                            if(detailCondition[i].food.equals("-") || detailCondition[i].food.equals(people[j].food)){
                                System.out.println("food = " + people[j].food);
                                if(Integer.parseInt(detailCondition[i].score) <= Integer.parseInt(people[j].score)){
                                    System.out.println("score = " + people[j].score);
                                    sum++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = sum;
            sum = 0;
        }

        for(int i : answer){
            System.out.println(i);
        }

    }
}
class People{
    String language;
    String job;
    String career;
    String food;
    String score;

    public People(String language, String job, String career, String food, String score){
        this.language = language;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score=score;
    }

}
