import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int[] arr = new int[9];
        int[] ans = {0,0};
        
        for(int i = 0; i < 9; i++) 
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        int sum = IntStream.of(arr).sum();
        
        outer:for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int x = arr[i] + arr[j];
                
                if(sum - x == 100) {
                    ans[0] = i;
                    ans[1] = j;
                    break outer;
                }
            }
        }
        
        
        for(int i = 0; i < 9; i++) {
            if(i == ans[0] || i == ans[1]) continue;
            System.out.println(arr[i]);
        }
    }
}