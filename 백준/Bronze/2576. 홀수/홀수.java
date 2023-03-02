import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int[] arr = new int[7];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        arr = IntStream.of(arr)
                    .filter(x -> x % 2 == 1)
                    .sorted()
                    .toArray();
        
        if(arr.length == 0) {
            System.out.println(-1);
            return;
        }
        
        int sum = IntStream.of(arr).sum();
        
        System.out.println(sum);
        System.out.println(arr[0]);
    }
}