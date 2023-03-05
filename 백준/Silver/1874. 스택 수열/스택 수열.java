import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (cur < num) {
                stack.addLast(cur+1);
                cur++;
                sb.append("+");
                sb.append("\n");
            }

            if (stack.getLast() > num) {
                System.out.println("NO");
                return;
            }

            if (stack.getLast() == num) {
                stack.removeLast();
                sb.append("-");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}