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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] distance = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nextX = cur[0] + dx[dir];
                int nextY = cur[1] + dy[dir];

                if(nextX < 0 || nextX >= n) continue;
                if(nextY < 0 || nextY >= m) continue;
                if(arr[nextX][nextY] == 0) continue;
                if(distance[nextX][nextY] >= 1) continue;

                distance[nextX][nextY] = distance[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nextX, nextY});
            }
        }

        System.out.println(distance[n-1][m-1]);
    }
}