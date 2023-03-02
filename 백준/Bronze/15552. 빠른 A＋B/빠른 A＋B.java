import java.io.*;
import java.util.*;

public class Main {
    
    private final static BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append('\n');
        }
        
        System.out.println(sb);
    }
}