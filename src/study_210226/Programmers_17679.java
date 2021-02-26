package study_210226;

/*
* 프렌즈 4블록
* 1. 2차원 배열로 변환
* 2. 오른쪽, 아래, 대각 아래 찾아서 체크
* 3. 한번에 지우고 내림
* 4. 반복 지울게 없어질 때 까지
* */
public class Programmers_17679 {
    static char[][] arr;
    static boolean[][] checked;
    static int m;
    static int n;
    static boolean flag = true;
    public static void main(String[] args){
        m = 6;
        n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        arr = new char[m][n];
        checked = new boolean[m][n];
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length(); j++){
                char ch = board[i].charAt(j);
                arr[i][j] = ch;
            }
        }

        while(flag) {
            flag = false;
            //4개씩 짝지어진 것 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    search(i, j);
                }
            }
            //찾은 것 없애기
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(checked[i][j]){
                        arr[i][j] = '\0';
                    }
                }
            }
            //내려야 할 것들 개수 찾기
            int cntDown = searchDown();

            //내리기
            while(cntDown > 0) {
                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n; j++) {
                        char ch = arr[i][j];
                        //아래가 비었고 내가 공백이 아니면
                        if (arr[i + 1][j] == '\0' && arr[i][j] != '\0') {
                            down(i, j,cntDown--);
                        }
                    }
                }
            }


            //checked 초기화
            checked = new boolean[m][n];


        }
        //개수 구하기
        int cnt = m*n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j]!='\0') cnt--;
            }
        }
        System.out.println(cnt);

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == '\0'){
                    System.out.print("  ");
                    continue;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



    }

    public static void search(int x, int y){
        char ch = arr[x][y];
        if(ch != '\0'&&arr[x][y+1] == ch && arr[x+1][y] == ch && arr[x+1][y+1]== ch){
            System.out.println(1);
            checked[x][y+1] = checked[x][y] = checked[x+1][y] = checked[x+1][y+1] = true;
            flag = true;
            return;
        }
    }
    public static void down(int x, int y,int cntDown){
        char ch = arr[x][y];
        //맨 아래가 비었으면 채우고 리턴
        if(arr[m-1][y] == '\0'){
            arr[m-1][y] = ch;
            arr[x][y] = '\0';
            return;
        }
        for(int i = x+1; i < m; i++){
            //공백이 아니면
            if(arr[i][y] != '\0'){
                arr[i-1][y] = ch;
                arr[x][y]= '\0';
                return;
            }
        }
    }
    public static int searchDown(){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (arr[i][j] != '\0') {
                    for(int k = i+1; k < m; k++){
                        if(arr[k][j]=='\0'){
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
