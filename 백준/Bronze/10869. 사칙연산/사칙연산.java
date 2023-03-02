import java.io.*;
import java.util.*;

public class Main {
    
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        sb.append(a+b).append('\n');
        sb.append(a-b).append('\n');
        sb.append(a*b).append('\n');
        sb.append(a/b).append('\n');
        sb.append(a%b).append('\n');
        
        System.out.println(sb.toString());
    }
}