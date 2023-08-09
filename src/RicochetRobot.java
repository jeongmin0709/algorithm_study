import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {
    public int solution(String[] board) {
        Queue<int[]> queue = new LinkedList<>();
        char[][] newBoard = new char[board.length][];
        // char[][] 배열로 변환
        for (int i=0 ;i< board.length; i++) newBoard[i] = board[i].toCharArray();
        boolean[][] visit = new boolean[newBoard.length][newBoard[0].length];
        // 시작위치 찾기
        for(int i=0; i< newBoard.length; i++){
            if(!queue.isEmpty())break;
            for(int j = 0; j<newBoard[i].length; j++){
                if(newBoard[i][j] == 'R'){
                    int[] start = {i, j, 0};
                    queue.offer(start);
                    visit[i][j] = true;
                    break;
                }
            }
        }
        // 탐색
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(newBoard[current[0]][current[1]] == 'G') return current[2];
            int[][] next = move(newBoard, current);
            for (int[] n: next){
                if(!visit[n[0]][n[1]]){
                    n[2] = current[2]+1;
                    queue.offer(n);
                    visit[n[0]][n[1]] = true;
                }
            }
        }


        return -1;
    }

    //상, 하, 좌, 우 다음위치 구하기
    public static int[][] move(char[][] board, int[] current) {
        //moveTop
        int[] nextTop = new int[3];
        int i= current[0];
        for(; i>=0; i--){
            if(board[i][current[1]] == 'D'){
                nextTop[0] = i+1;
                nextTop[1] = current[1];
                break;
            }
        }
        if(i == -1){
            nextTop[0] = 0;
            nextTop[1] = current[1];
        }

        //moveBottom
        int[] nextBottom = new int[3];
        i = current[0];
        for(; i<board.length; i++){
            if(board[i][current[1]] == 'D'){
                nextBottom[0] = i-1;
                nextBottom[1] = current[1];
                break;
            }
        }
        if(i == board.length){
            nextBottom[0] = board.length-1;
            nextBottom[1] = current[1];
        }

        //moveLeft
        int j = current[1];
        int[] nextLeft = new int[3];
        for(;j>=0; j--){
            if(board[current[0]][j] == 'D'){
                nextLeft[0] = current[0];
                nextLeft[1] = j+1;
                break;
            }
        }
        if(j == -1){
            nextLeft[0] = current[0];
            nextLeft[1] = 0;
        }
        //moveRight
        j = current[1];
        int[] nextRight = new int[3];
        for(;j < board[current[0]].length; j++){
            if(board[current[0]][j] == 'D'){
                nextRight[0] = current[0];
                nextRight[1] = j-1;
                break;
            }
        }
        if(j == board[current[0]].length){
            nextRight[0] = current[0];
            nextRight[1] = board[current[0]].length-1;
        }
        int[][] next = {nextTop, nextBottom, nextLeft, nextRight};
        return next;
    }
}
