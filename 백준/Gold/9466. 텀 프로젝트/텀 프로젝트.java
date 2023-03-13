import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int CYCLE = -1;
    private static final int NOT_VISITED = 0;

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            int[] state = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (state[j] == NOT_VISITED) bfs(j, arr, state);
            }

            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (state[j] != CYCLE) cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }

    public static void bfs(int start, int[] arr, int[] state) {
        int cur = start;

        while (true) {
            state[cur] = start;
            cur = arr[cur];

            // 싸이클인 경우
            if (state[cur] == start) {
                while (state[cur] != CYCLE) {
                    state[cur] = CYCLE;
                    cur = arr[cur];
                }
                return;
            }

            // 싸이클이 아닌데 방문한 경우
            if (state[cur] != NOT_VISITED) return;
        }
    }
}