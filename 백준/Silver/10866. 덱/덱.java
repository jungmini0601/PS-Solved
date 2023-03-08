import java.util.*;
import java.util.stream.*;
import java.io.*;

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
        Deque<Integer> deque = new ArrayDeque<>();

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.removeLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.getFirst() + "\n");
                    break;
                case "back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.getLast() + "\n");
                    break;
            }
        }

        bw.flush();
    }
}