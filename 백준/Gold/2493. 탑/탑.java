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
        int[] topArr = Stream.of(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();
        int[] answer = new int[topArr.length];
        // (높이, 인덱스)
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = topArr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.addLast(new int[]{topArr[i], i});
                continue;
            }
            
            while(!stack.isEmpty() && stack.getLast()[0] < topArr[i]) {
                int[] top = stack.removeLast();
                int index = top[1];
                answer[index] = i + 1;
            }
            
            stack.addLast(new int[]{topArr[i], i});
        }
        
        for(int i = 0; i < topArr.length; i++) {
            bw.write(answer[i] + " ");
        }
        
        bw.flush();
        bw.close();
    }
}