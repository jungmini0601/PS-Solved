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
        Deque<Integer> queue = new ArrayDeque<>();
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch(command) {
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    queue.addLast(data);
                    break;
                case "pop":
                    if(queue.size() == 0) {
                        bw.write("-1");
                        bw.write("\n");
                    } else {
                        bw.write(queue.removeFirst() + "");
                        bw.write("\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "");
                    bw.write("\n");
                    break;
                case "empty":
                    if(queue.size() == 0) {
                        bw.write("1");
                        bw.write("\n");
                    } else {
                        bw.write("0");
                        bw.write("\n");
                    }
                    break;
                case "front":
                    if(queue.size() == 0) {
                        bw.write("-1");
                        bw.write("\n");
                    } else {
                        bw.write(queue.getFirst() + "");
                        bw.write("\n");
                    }
                    break;
                case "back":
                    if(queue.size() == 0) {
                        bw.write("-1");
                        bw.write("\n");
                    } else {
                        bw.write(queue.getLast() + "");
                        bw.write("\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}