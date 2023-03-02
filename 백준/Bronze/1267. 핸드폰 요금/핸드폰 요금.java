import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        
        int mSum = 0;
        int ySum = 0;
        
        for (int time : arr) {
            mSum += (time / 60 + 1) * 15;
            ySum += (time / 30 + 1) * 10;
        }
        
        if(mSum == ySum) {
            System.out.println("Y M " + mSum);
            return;
        }
        
        char c = mSum < ySum ? 'M' : 'Y';
        int sum = mSum < ySum ? mSum : ySum;
        
        System.out.println(c + " " + sum);
    }
}