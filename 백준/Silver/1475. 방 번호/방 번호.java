import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        String number = br.readLine();
        List<Integer> numbers = 
            new ArrayList(Collections.nCopies(9, 0));
        
        for(char c: number.toCharArray()) {
            if(c == '6' || c == '9') {
                numbers.set(6, numbers.get(6) + 1);
                continue;
            }
            int index = c - '0';
            numbers.set(index, numbers.get(index) + 1);
        }
        
        if(numbers.get(6) % 2 == 0) {
            numbers.set(6, numbers.get(6) / 2);
        } else {
            numbers.set(6, numbers.get(6) / 2 + 1);
        }
        
        int max = numbers.stream().mapToInt(Integer::valueOf).max().orElse(0);
        System.out.println(max);
    }
}