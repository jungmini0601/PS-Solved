import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        while(n-- > 0) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    stack.addLast(data);
                    break;
                case "top":
                    if(stack.size() == 0) {
                        bw.write(-1 + "");
                        bw.write("\n");
                    } else {
                        bw.write(stack.getLast() + "");
                        bw.write("\n");
                    }
                    break;
                case "pop":
                    if(stack.size() == 0) {
                        bw.write(-1 + "");
                        bw.write("\n");
                    } else {
                        bw.write(stack.removeLast() + "");
                        bw.write("\n");
                    }
                    break;
                case "empty":
                    bw.write(stack.size() == 0 ? "1" : "0");
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(stack.size() + "");
                    bw.write("\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}