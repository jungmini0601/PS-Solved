import java.util.*;
import java.io.*;

public class Main {

    private final static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];

        initArea(n, area);
        labelArea(n, area);

        int ans = Integer.MAX_VALUE;

        // area를 돌면서 대륙이면 BFS를 돌리고 최소 값을 찾아낸다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 0) continue;

                int[][] distance = new int[n][n];
                int[] dx = {-1, 0, 1, 0,};
                int[] dy = {0, 1, 0, -1};

                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i,j});
                int curAreaNum = area[i][j];

                outer:while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];

                        if (nextX < 0 || nextX >= n) continue;
                        if (nextY < 0 || nextY >= n) continue;
                        if (area[nextX][nextY] == curAreaNum) continue;
                        if (distance[nextX][nextY] > 0 && area[nextX][nextY] == 0) continue;

                        if (area[nextX][nextY] != 0 && area[nextX][nextY] != curAreaNum) {
                            ans = Math.min(ans, distance[curX][curY]);
                            break outer;
                        } else {
                            queue.add(new int[]{nextX, nextY});
                            distance[nextX][nextY] = distance[curX][curY] + 1;
                        }
                    }
                }
            }
        }

//        printArea(n, area);
        System.out.println(ans);
    }

    public static void printArea(int n, int[][] area) {
        System.out.println("==============================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    public static void labelArea(int n, int[][] area) {
        int areaNum = 2;
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, 0, 1, 0,};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(area[i][j] == 0) continue;
                if (visited[i][j]) continue;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                area[i][j] = areaNum;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];

                        if (nextX < 0 || nextX >= n) continue;
                        if (nextY < 0 || nextY >= n) continue;
                        if (area[nextX][nextY] == 0) continue;
                        if (visited[nextX][nextY]) continue;

                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        area[nextX][nextY] = areaNum;
                    }
                }

                areaNum++;
            }
        }
    }

    public static void initArea(int n, int[][] area) throws Exception {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}