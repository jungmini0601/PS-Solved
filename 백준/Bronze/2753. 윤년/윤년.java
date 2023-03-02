import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final BufferedReader br
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int year = Integer.parseInt(br.readLine());
        boolean condition1 = (year % 4 == 0) && (year % 100 != 0);
        boolean condition2 = year % 400 == 0;

        System.out.println(condition1 || condition2 ? 1 : 0);
    }
}