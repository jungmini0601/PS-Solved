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
            int n = Integer.parseInt(br.readLine());
            int[] start = new int[2];
            int[] end = new int[2];
            int[] dx = {-2,-1,1,2,2,1,-1,-2};
            int[] dy = {1,2,2,1,-1,-2,-2,-1};
            int[][] distance = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            if(start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }


            Queue<int[]> queue = new ArrayDeque<>();
            distance[start[0]][start[1]] = 1;
            queue.offer(new int[]{start[0], start[1]});

            outer: while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int dir = 0; dir < 8; dir++) {
                    int nextX = curX + dx[dir];
                    int nextY = curY + dy[dir];

                    if(nextX < 0 || nextX >= n) continue;
                    if(nextY < 0 || nextY >= n) continue;
                    if(distance[nextX][nextY] >= 1) continue;
                    distance[nextX][nextY] = distance[curX][curY] + 1;
                    queue.offer(new int[]{nextX, nextY});

                    if(nextX == end[0] && nextY == end[1]) {
                        bw.write((distance[nextX][nextY] - 1) + "\n");
                        bw.flush();
                        break outer;
                    }
                }
            }
        }
    }
}