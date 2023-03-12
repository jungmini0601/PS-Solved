
import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;

        while (true) {
            if (isEnd(board, n, m)) {
                System.out.println(0);
                break;
            }

            int cnt = bfs(board, n, m);
            if (cnt >= 2) {
                System.out.println(t);
                break;
            }

            // 녹이기 시작
            int[][] zeroArr = new int[n][m];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            int nextX = i + dx[dir];
                            int nextY = j + dy[dir];

                            if (nextX < 0 || nextX >= n) continue;
                            if (nextY < 0 || nextY >= m) continue;
                            if (board[nextX][nextY] == 0) {
                                zeroArr[i][j]++;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] -= zeroArr[i][j];
                    if (board[i][j] <= 0) board[i][j] = 0;
                }
            }

            //for (int i = 0; i < n; i++) {
                //for (int j = 0; j < m; j++) {
                  //  System.out.print(board[i][j] + " ");
                //}
              //  System.out.println();
            //}
            //System.out.println("======================");
            t++;
        }
    }

    public static boolean isEnd(int[][] board, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int bfs(int[][] board, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
                if (visited[i][j]) continue;
                cnt++;
                visited[i][j] = true;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];

                        if (nextX < 0 || nextX >= n) continue;
                        if (nextY < 0 || nextY >= m) continue;
                        if (visited[nextX][nextY]) continue;
                        if (board[nextX][nextY] == 0) continue;
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return cnt;
    }
}