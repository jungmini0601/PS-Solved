import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int target = Integer.parseInt(br.readLine());
        
        int[] arr = new int[2000001];
        int ans = 0;
        Arrays.stream(numbers).forEach(number -> arr[number] = 1);
        
        for(int i = 1; i < arr.length; i++) {
            if(target - i < 0) continue;
            if(arr[target - i] == 1 && arr[i] == 1) {
                ans++;
            }
        }
        
        System.out.println(ans / 2);
    }
}