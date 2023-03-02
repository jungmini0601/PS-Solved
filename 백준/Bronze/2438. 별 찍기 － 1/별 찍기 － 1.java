import java.util.*;
import java.io.*;

public class Main {
    private final static BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) sb.append('*');
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
}