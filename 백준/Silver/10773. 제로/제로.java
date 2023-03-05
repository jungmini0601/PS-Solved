import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    private final static BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    private final static BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int k = Integer.parseInt(br.readLine());
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        while(k-- > 0) {
            int data = Integer.parseInt(br.readLine());
            if(data == 0 && stack.size() != 0) stack.removeLast();
            else stack.addLast(data);
        }
        
        while(stack.size() != 0) {
            sum += stack.removeLast();
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}