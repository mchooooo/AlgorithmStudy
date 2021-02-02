package study_210202;

public class Programmers_72413 {

    public static void main(String[] args){
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int[][] arr = new int[n+1][n+1];

        for(int i = 0; i < fares.length; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int z = fares[i][2];

            arr[x][y] = arr[y][x] = z;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //연결되지 않은 경로 충분히 큰 값
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                if(i!=j && arr[i][j]==0){
                    arr[i][j]= 10000001;
                }
            }
        }
        //플로이드 워샬
        for(int k = 1; k < arr.length; k++){
            for(int i = 1; i < arr.length; i++){
                for(int j = 1; j < arr.length; j++){
                    if(i!=k && j!=k && j!=i) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }
        }

        int answer = 10000001;

        //최소 비용 구하는 부분 i는 a와b가 헤어지는 지점
        for(int i = 1; i < arr.length; i++){
            int sum = arr[s][i]+arr[i][a]+arr[i][b];
            answer = Math.min(answer,sum);
        }

        System.out.println(answer);

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

}
