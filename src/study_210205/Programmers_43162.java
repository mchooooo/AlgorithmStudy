package study_210205;

public class Programmers_43162 {
    public static void main(String[] args){
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0},{0, 0, 1}};

        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer += dfs(i,computers,visited);
            }
        }
        System.out.println(answer);
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers.length; j++){
                System.out.print(computers[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static int dfs(int n, int[][] computers, boolean[] visited){
        if(visited[n]) return 0;
        visited[n] = true;
        for(int i = 0; i < computers.length; i++){
            if(computers[n][i]==1 && !visited[i]){
                dfs(i,computers,visited);
            }
        }
        return 1;
    }
}
