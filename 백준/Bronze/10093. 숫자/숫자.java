import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        
        if(start == end) {
            System.out.println(0);
            return;
        }
        
        StringBuilder sb = new StringBuilder(end - start - 1 + "").append("\n");
        for(long i = start + 1; i < end; i++) sb.append(i).append(" ");
        System.out.println(sb);
    }
}