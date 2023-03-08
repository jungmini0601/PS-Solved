import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private final static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            Deque<Character> deque = new ArrayDeque<>();
            boolean isBalance = true;

            for (char c: input.toCharArray()) {
                if (c == '[' || c == '(') {
                    deque.addLast(c);
                    continue;
                }

                if (c == ']') {
                    if (!deque.isEmpty() && deque.getLast() == '[') {
                        deque.removeLast();
                    } else {
                        isBalance = false;
                        break;
                    }
                }

                if (c == ')') {
                    if (!deque.isEmpty() && deque.getLast() == '(') {
                        deque.removeLast();
                    } else {
                        isBalance = false;
                        break;
                    }
                }
            }

            if (!deque.isEmpty()) isBalance = false;

            System.out.println(isBalance ? "yes" : "no");
        }
    }
}
