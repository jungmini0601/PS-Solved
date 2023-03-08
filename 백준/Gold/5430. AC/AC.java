import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private final static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            String subArrStr = arrStr.substring(1, arrStr.length() - 1);

            int[] arr = null;

            if(n == 0) {
                arr = new int[0];
            } else {
                arr = Stream.of(subArrStr.split(",")).mapToInt(Integer::parseInt).toArray();
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for(int elem: arr) deque.addLast(elem);

            boolean isFront = true;
            boolean isError = false;

            for(char c : command.toCharArray()) {
                if(c == 'R') {
                    isFront = !isFront;
                    continue;
                }

                if(deque.isEmpty()) {
                    isError = true;
                    break;
                } else {
                    if(isFront) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if(isError) {
                bw.write("error\n");
            } else {
                bw.write("[");

                while(deque.size() > 0) {
                    if(isFront) {
                        bw.write(deque.removeFirst()+ "");
                    } else {
                        bw.write(deque.removeLast()+ "");
                    }

                    if(deque.size() > 0) bw.write(",");
                }

                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
    }
}