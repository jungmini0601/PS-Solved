

import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][][] distance = new int[n][m][2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                board[i][j] = c - '0';
            }
        }

        distance[0][0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if(nextX < 0 || nextX >= n) continue;
                if(nextY < 0 || nextY >= m) continue;

                // 벽을 안 부순 경우
                if (distance[curX][curY][0] >= 1) {
                    if (board[nextX][nextY] == 1) {
                        if (distance[curX][curY][0] + 1 >= distance[nextX][nextY][1] && distance[nextX][nextY][1] != 0) continue;
                        distance[nextX][nextY][1] = distance[curX][curY][0] + 1;
                        queue.add(new int[]{nextX, nextY});
                    } else {
                        if (distance[curX][curY][0] + 1 >= distance[nextX][nextY][0] && distance[nextX][nextY][0] != 0) continue;
                        distance[nextX][nextY][0] = distance[curX][curY][0] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
                // 벽을 부순 경우
                if(distance[curX][curY][1] >= 1) {
                    if (board[nextX][nextY] == 1) continue;
                    if (distance[curX][curY][1] + 1 >= distance[nextX][nextY][1] && distance[nextX][nextY][1] != 0) continue;
                    distance[nextX][nextY][1] = distance[curX][curY][1] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        
        if (distance[n-1][m-1][0] == 0 && distance[n-1][m-1][1] == 0) {
            System.out.println(-1);
        } else if (distance[n-1][m-1][0] >= 1 && distance[n-1][m-1][1] >= 1) {
            System.out.println(Math.min(distance[n-1][m-1][0], distance[n-1][m-1][1]));
        } else if (distance[n-1][m-1][0] >= 1) {
            System.out.println(distance[n-1][m-1][0]);
        } else {
            System.out.println(distance[n-1][m-1][1]);
        }
    }
}