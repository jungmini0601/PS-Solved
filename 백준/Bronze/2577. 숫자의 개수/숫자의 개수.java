import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        List<Integer> occuers =
                new ArrayList<>(Collections.nCopies(10, 0));

        String num = a * b * c + "";

        for(char cNum : num.toCharArray()) {
            int index = cNum - '0';
            occuers.set(index, occuers.get(index) + 1);
        }

        StringBuilder sb = new StringBuilder();
        occuers.stream()
                .forEach(x -> sb.append(x).append('\n'));

        System.out.println(sb);
    }
}