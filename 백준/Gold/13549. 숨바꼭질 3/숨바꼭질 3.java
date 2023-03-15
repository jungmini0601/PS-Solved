import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] distance = new int[200001];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        distance[n] = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) {
                System.out.println(distance[cur]);
                return;
            }

            int[] nextPoints = {cur * 2, cur-1, cur + 1};

            for (int nextPoint :nextPoints) {
                if (nextPoint < 0 || nextPoint >= 200000) continue;
                if (distance[nextPoint] >= 0) continue;

                if (nextPoint == cur * 2) {
                    distance[nextPoint] = distance[cur];
                    queue.add(nextPoint);
                } else {
                    distance[nextPoint] = distance[cur] + 1;
                    queue.add(nextPoint);
                }
            }
        }
    }
}