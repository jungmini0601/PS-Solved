import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] board = new int[h][n][m];
        int[][][] distance = new int[h][n][m];
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curZ = cur[0];
            int curX = cur[1];
            int curY = cur[2];

            for(int dir = 0; dir < 6; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];
                int nextZ = curZ + dz[dir];

                if(nextX < 0 || nextX >= n) continue;
                if(nextY < 0 || nextY >= m) continue;
                if(nextZ < 0 || nextZ >= h) continue;
                if(board[nextZ][nextX][nextY] == 1) continue;
                if(board[nextZ][nextX][nextY] == -1) continue;

                queue.add(new int[]{nextZ, nextX, nextY});
                board[nextZ][nextX][nextY] = 1;
                distance[nextZ][nextX][nextY] = distance[curZ][curX][curY] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(board[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if(board[i][j][k] == 1) {
                        max = Math.max(max, distance[i][j][k]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}