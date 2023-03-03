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
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) deque.add(i);

        bw.write("<");

        int cnt = 1;
        while (deque.size() > 0) {
            if (cnt % k == 0) {
                bw.write(deque.removeFirst().toString());

                if (deque.size() != 0) {
                    bw.write(", ");
                }
                cnt++;
                continue;
            }

            deque.addLast(deque.removeFirst());
            cnt++;
        }

        bw.write('>');
        bw.flush();
    }
}