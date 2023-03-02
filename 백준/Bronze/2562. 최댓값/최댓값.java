import java.util.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int maxIndex = 0;
        int maxValue = -1;
        
        for(int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        
        System.out.println(maxValue);
        System.out.println(maxIndex + 1);
    }
}