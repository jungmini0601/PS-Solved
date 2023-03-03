import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for(char c: str.toCharArray()) list.add(c);

        int m = Integer.parseInt(br.readLine());


        ListIterator<Character> iter = list.listIterator(list.size());

        while (m-- > 0) {
            String input = br.readLine();
            char command = ' ';
            char data = ' ';

            if(input.length() == 1) {
                command = input.charAt(0);
            } else {
                command = input.charAt(0);
                data = input.charAt(input.length()-1);
            }

            switch (command) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(data);
                    break;
            }
        }

        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}