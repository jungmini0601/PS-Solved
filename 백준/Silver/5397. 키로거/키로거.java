import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    private static final BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String input = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            for(char c: input.toCharArray()) {
                if(c == '<') {
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (c == '>') {
                    if(iter.hasNext()) {
                        iter.next();
                    }
                } else if (c == '-') {
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(c);
                }
            };

            for(Character c: list) {
                bw.write(c);
            }
            bw.write('\n');
        }

        bw.flush();
    }
}