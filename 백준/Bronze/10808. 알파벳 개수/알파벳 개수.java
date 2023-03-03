import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));

        for(char c : input.toCharArray()) {
            int index = c - 'a';
            list.set(index, list.get(index) + 1);
        }

        StringBuilder sb = new StringBuilder();
        list.stream().forEach(el -> sb.append(el).append(" "));
        System.out.println(sb);
    }
}