import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] weaknessVisited = new boolean[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;
        int weaknessCnt = 0;
        
        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    cnt++;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        
                        for(int dir = 0; dir < 4; dir++) {
                            int nextX = curX + dx[dir];
                            int nextY = curY + dy[dir];
                            
                            if(nextX < 0 || nextX >= n) continue;
                            if(nextY < 0 || nextY >= n) continue;
                            if(visited[nextX][nextY]) continue;
                            if(board[curX][curY] != board[nextX][nextY]) continue;
                            visited[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
                
                if(!weaknessVisited[i][j]) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    weaknessVisited[i][j] = true;
                    weaknessCnt++;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        
                        for(int dir = 0; dir < 4; dir++) {
                            int nextX = curX + dx[dir];
                            int nextY = curY + dy[dir];
                            
                            if(nextX < 0 || nextX >= n) continue;
                            if(nextY < 0 || nextY >= n) continue;
                            if(weaknessVisited[nextX][nextY]) continue;
                            if(board[curX][curY] == 'R' && board[nextX][nextY] == 'B') continue;
                            if(board[curX][curY] == 'G' && board[nextX][nextY] == 'B') continue;
                            if(board[curX][curY] == 'B' && board[nextX][nextY] == 'R') continue;
                            if(board[curX][curY] == 'B' && board[nextX][nextY] == 'G') continue;
                            
                            weaknessVisited[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
        
        System.out.println(cnt + " " + weaknessCnt);
    }
}