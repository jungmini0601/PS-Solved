import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
                               
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i,j});
                       
                        while(!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            int curX = cur[0];
                            int curY = cur[1];
                            
                            for(int dir = 0; dir < 4; dir++) {
                                int nx = curX + dx[dir];
                                int ny = curY + dy[dir];
                                
                                if(nx < 0 || nx >= n) continue;
                                if(ny < 0 || ny >= m) continue;
                                if(board[nx][ny] == 0) continue;
                                if(visited[nx][ny]) continue;
                                
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            
            bw.write(cnt + "\n");
            bw.flush();
        }
    }
}