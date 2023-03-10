import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[] distance = new int[200001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for(int next: nexts) {
                if(next == k) {
                    System.out.println(distance[cur] + 1);
                    return;
                }
                if(next < 0 || next >= 200001) continue;
                if(next == n) continue;
                if(distance[next] >= 1) continue;
                distance[next] = distance[cur] + 1;
                queue.offer(next);
            }
        }
    }
}