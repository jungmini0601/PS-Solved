import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        outer: while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] board = new char[h][w];
            int[][] fireDistance = new int[h][w];
            int[][] sangunDistance = new int[h][w];
            int[] dx = {-1, 0 , 1, 0};
            int[] dy = {0, 1, 0, -1};

            Queue<int[]> fireQueue = new ArrayDeque<>();
            Queue<int[]> sangunQueue = new ArrayDeque<>();

            for(int i = 0; i < h; i++) {
                String input = br.readLine();
                for(int j = 0; j < w; j++) {
                    board[i][j] = input.charAt(j);
                    if(board[i][j] == '@') {
                        sangunQueue.offer(new int[]{i, j});
                    } else if (board[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                    }
                }
            }

            while(!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int dir = 0; dir < 4; dir++) {
                    int nextX = curX + dx[dir];
                    int nextY = curY + dy[dir];

                    if(nextX < 0 || nextX >= h) continue;
                    if(nextY < 0 || nextY >= w) continue;
                    if(board[nextX][nextY] == '*') continue;
                    if(board[nextX][nextY] == '#') continue;
                    if(fireDistance[nextX][nextY] >= 1) continue;
                    fireDistance[nextX][nextY] = fireDistance[curX][curY] + 1;
                    fireQueue.offer(new int[]{nextX, nextY});
                }
            }

            while(!sangunQueue.isEmpty()) {
                int[] cur = sangunQueue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int dir = 0; dir < 4; dir++) {
                    int nextX = curX + dx[dir];
                    int nextY = curY + dy[dir];

                    if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
                        bw.write((sangunDistance[curX][curY] + 1) + "\n");
                        bw.flush();
                        continue outer;
                    }

                    if(board[nextX][nextY] == '*') continue;
                    if(board[nextX][nextY] == '#') continue;
                    if(board[nextX][nextY] == '@') continue;
                    if(sangunDistance[nextX][nextY] >= 1) continue;
                    if(sangunDistance[curX][curY] + 1 >= fireDistance[nextX][nextY]  && fireDistance[nextX][nextY] >= 1) continue;
                    sangunDistance[nextX][nextY] = sangunDistance[curX][curY] + 1;
                    sangunQueue.offer(new int[]{nextX, nextY});
                }
            }

            bw.write("IMPOSSIBLE\n");
            bw.flush();
        }
    }
}