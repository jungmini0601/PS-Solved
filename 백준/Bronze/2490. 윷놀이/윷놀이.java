import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 3; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int zeroCnt = 0;
        
            for(int elem: arr) {
                if(elem == 0) zeroCnt++;
            }
        
            char ans = 'E';
        
            switch(zeroCnt) {
                case 1:
                    ans = 'A';
                    break;
                case 2:
                    ans = 'B';
                    break;
                case 3:
                    ans = 'C';
                    break;
                case 4:
                    ans = 'D';
                    break;
            }
    
            System.out.println(ans);
        }
    }
}