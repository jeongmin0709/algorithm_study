import java.util.LinkedList;
import java.util.Queue;

public class MazeEscape {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] start;
    static int[] lever;
    static char[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps.length];
        for(int i=0 ;i<maps.length; i++) map[i] = maps[i].toCharArray();
        // 시작위치 찾기
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                if(map[i][j] == 'S') start = new int[]{i, j, 0};
                if(map[i][j] == 'L') lever = new int[]{i, j, 0};
            }
        }
        //시작위치부터 레버까지 dfs르 최단거리 찾기
        int startToLever = bfs(start, 'L');
        if(startToLever == -1) return -1;
        //레버부터 탈출위치까지 dfs르 최단거리 찾기
        int leverToExit = bfs(lever, 'E');
        if(leverToExit == -1) return -1;
        return startToLever + leverToExit;
    }
    private static int bfs(int[] start, char target){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[map.length][map.length];
        visit[start[0]][start[1]] = true;
        queue.offer(start);
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            if(map[current[0]][current[1]] == target) return current[2];
            for(int i=0; i<4; i++){
                int nextY = current[0] + dy[i];
                int nextX = current[1] + dx[i];
                if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length ) continue;
                if(!visit[nextY][nextX] && map[nextY][nextX] != 'X'){
                    visit[nextY][nextX] = true; // 방문처리
                    queue.offer(new int[]{nextY, nextX, current[2]+1});
                }
            }
        }
        return -1;
    }
}
