import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int score = Integer.parseInt(br.readLine());
        char ans = ' ';
            
        switch(score / 10) {
            case 10:
            case 9:
                ans = 'A';
                    break;
            case 8:
                ans = 'B';
                    break;
            case 7:
                ans = 'C';
                    break;
            case 6:
                ans = 'D';
                    break;
            default:
                ans = 'F';
                    break;
        }
        
        System.out.println(ans);
    }
}