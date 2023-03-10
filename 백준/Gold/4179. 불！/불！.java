import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        int[][] fireDistance = new int[r][c];
        int[][] jihunDistance = new int[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> fireQueue = new ArrayDeque<>();
        Queue<int[]> jihunQueue = new ArrayDeque<>();

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                char elem = input.charAt(j);
                if(elem == 'J') {
                    jihunQueue.offer(new int[]{i,j});
                } else if(elem == 'F') {
                    fireQueue.offer(new int[]{i,j});
                }

                arr[i][j] = elem;
            }
        }

        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if(nextX < 0 || nextX >= r) continue;
                if(nextY < 0 || nextY >= c) continue;
                if(arr[nextX][nextY] == '#') continue;
                if(arr[nextX][nextY] == 'F') continue;
                if(fireDistance[nextX][nextY] >= 1) continue;

                fireDistance[nextX][nextY] = fireDistance[curX][curY] + 1;
                fireQueue.add(new int[]{nextX, nextY});
            }
        }

        while(!jihunQueue.isEmpty()) {
            int[] cur = jihunQueue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) {
                    System.out.println(jihunDistance[curX][curY] + 1);
                    return ;
                }
                if(arr[nextX][nextY] == '#') continue;
                if(arr[nextX][nextY] == 'F') continue;
                if(jihunDistance[nextX][nextY] >= 1) continue;
                if (jihunDistance[curX][curY] + 1 >= fireDistance[nextX][nextY] && fireDistance[nextX][nextY] >= 1) continue;

                jihunDistance[nextX][nextY] = jihunDistance[curX][curY] + 1;
                jihunQueue.offer(new int[]{nextX, nextY});
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}