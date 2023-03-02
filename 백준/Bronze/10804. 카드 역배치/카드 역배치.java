import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int[] arr = new int[21];
        
        for(int i = 1; i <= 20; i++) arr[i] = i;
        
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = (end - start + 1) / 2;
            
            
            for(int j = 0; j < length; j++) {
                int temp = arr[start + j];
                arr[start + j] = arr[end - j];
                arr[end - j] = temp;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 20; i++) sb.append(arr[i]).append(" ");
        
        System.out.println(sb);
    }
}
