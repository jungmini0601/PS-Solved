import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    int area = 1;
                    cnt++;

                    while(!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        int curX = pos[0];
                        int curY = pos[1];

                        for(int dir = 0; dir < 4; dir++) {
                            int nextX = curX + dx[dir];
                            int nextY = curY + dy[dir];

                            if(nextX < 0 || nextX >= n) continue;
                            if(nextY < 0 || nextY >= m) continue;
                            if(arr[nextX][nextY] == 0) continue;
                            if(visited[nextX][nextY]) continue;

                            visited[nextX][nextY] = true;
                            area++;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }

                    max = Math.max(max, area);
                }
            }
        }

        bw.write(cnt + "\n");
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}